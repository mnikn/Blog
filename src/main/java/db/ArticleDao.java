package db;

import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/25
 */
public class ArticleDao {
    public static List<Article> getAllArticles(){
        ResultSet resultSet = DbUtils.executeQuery("SELECT * FROM blog.article");
        return getArticles(resultSet);

    }

    public static List<Article> getArticlesByType(String type){
        ResultSet resultSet = DbUtils.executeQuery("SELECT * FROM blog.article " +
                "WHERE type = " + "\"" + type + "\"");
        return getArticles(resultSet);
    }

    public static List<Article> getArticlesByLabel(String label){
        ResultSet resultSet = DbUtils.executeQuery("SELECT * FROM blog.article INNER JOIN " +
                "blog.label ON blog.article.id = blog.label.article_id " +
                "WHERE label = " + "\"" + label + "\"");
        return getArticles(resultSet);
    }

    public static void updateTypes(){
        Set<String> set = AccountManager.getTypes();
        for(Article article : getAllArticles()) {
            set.add(article.getType());
        }
    }

    public static void updateLabelTypes(){
        Set<String> labels = AccountManager.getLabelTypes();
        ResultSet resultSet = DbUtils.executeQuery("SELECT article_id,label FROM blog.article INNER JOIN " +
                "blog.label ON blog.article.id = blog.label.article_id");
        try {
            while(resultSet.next()){
                labels.add(resultSet.getString("label"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Article getArticle(long id){
        ResultSet resultSet =
                DbUtils.executeQuery("SELECT * FROM blog.article where id = " + id);
        try {
            resultSet.next();
            Article article = findArticle(resultSet);
            ResultSet labelSet = DbUtils.executeQuery("SELECT article_id,label FROM blog.article INNER JOIN " +
                    "blog.label ON blog.article.id = " + article.getId());

            List<String> strings = new ArrayList<>();
            while(labelSet.next()) strings.add(labelSet.getString("label"));
            article.setLabels(strings);
            resultSet.close();
            labelSet.close();
            return article;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertArticle(Article article){
        int insertId = DbUtils.executeDataChange(
                "INSERT INTO blog.article " +
                        "(intro,md_content,html_content,title,type,created_at)" +
                        " VALUES " + valueString(article));
        AccountManager.getTypes().add(article.getType());
        updateLabelTypes();
        System.out.println("insertId: " + insertId);
    }

    private static Article findArticle(ResultSet resultSet){
        Article article = new Article();
        try {
            if(!resultSet.isAfterLast()){
                article.setId(resultSet.getLong("id"));
                article.setTitle(resultSet.getString("title"));
                article.setIntro(resultSet.getString("intro"));
                article.setMdContent(resultSet.getString("md_content"));
                article.setHtmlContent(resultSet.getString("html_content"));
                article.setType(resultSet.getString("type"));
                article.setCreatedAt(resultSet.getDate("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    private static List<Article> getArticles(ResultSet resultSet){
        List<Article> articles = new ArrayList<>();
        try {
            while (resultSet.next()){
                articles.add(findArticle(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    private static String valueString(Article article){
        return "(" +
                "\"" +
                article.getIntro() +
                "\"" +
                "," +
                "\"" +
                article.getMdContent() +
                "\"" +
                "," +
                "\"" +
                article.getHtmlContent() +
                "\"" +
                "," +
                "\"" +
                article.getTitle() +
                "\"" +
                "," +
                "\"" +
                article.getType() +
                "\"" +
                "," +
                "\"" +
                new SimpleDateFormat("yyyy-MM-dd").format(article.getCreatedAt()) +
                "\"" + ");";
    }
}
