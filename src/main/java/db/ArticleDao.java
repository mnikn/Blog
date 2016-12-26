package db;

import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/25
 */
public class ArticleDao {
    public static List<Article> getAllArticles(){
        List<Article> articles = new ArrayList<>();
        ResultSet resultSet = DbUtils.executeQuery("SELECT * FROM blog.article");
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

    public static Article getArticle(long id){
        ResultSet resultSet =
                DbUtils.executeQuery("SELECT * FROM blog.article where id = " + id);
        try {
            resultSet.next();
            Article article = findArticle(resultSet);
            resultSet.close();
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
