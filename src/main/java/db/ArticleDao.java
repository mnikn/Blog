package db;

import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/25
 */
public class ArticleDao {
    public static List<Article> getAllArticles(){
        List<Article> articles = null;
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blog.article");
            articles = getArticles(resultSet);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public static List<Article> getArticlesByType(String type){
        List<Article> articles = null;
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blog.article " +
                    "WHERE type = " + "\"" + type + "\"");
            articles = getArticles(resultSet);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public static List<Article> getArticlesByLabel(String label) {
        List<Article> articles = null;
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blog.article INNER JOIN " +
                    "blog.label ON blog.article.id = blog.label.article_id " +
                    "WHERE label = " + "\"" + label + "\"");
            articles = getArticles(resultSet);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    private static List<Article> getArticles(ResultSet resultSet){
        List<Article> articles = new ArrayList<>();
        try {
            while (resultSet.next()){
                articles.add(getArticle(resultSet.getLong("id")));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public static Article getArticle(long id){
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM blog.article WHERE id = " + id);
            resultSet.next();
            Statement labelStatement = DbUtils.getConnection().createStatement();
            Article article = setArticle(resultSet);
            ResultSet labelSet = labelStatement.executeQuery(
                    "SELECT * FROM blog.label WHERE article_id = "
                            + article.getId());

            List<String> strings = new ArrayList<>();
            while(labelSet.next()) strings.add(labelSet.getString("label"));
            article.setLabels(strings);

            resultSet.close();
            labelSet.close();
            statement.close();
            labelStatement.close();

            return article;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertArticle(Article article){
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            statement.executeUpdate(
                    "INSERT INTO blog.article " +
                            "(intro,md_content,html_content,title,type,created_at)" +
                            " VALUES " + valueString(article));
            Statement labelStatement = DbUtils.getConnection().createStatement();
            for(String label : article.getLabels()){
                labelStatement.executeUpdate(
                        "INSERT INTO blog.label " +
                                "(article_id,label)" +
                                " VALUES " + "(" + getLastArticleId() + ","
                                + "\"" + label + "\"" + ");");
            }

            statement.close();
            labelStatement.close();

            AccountManager.getTypes().add(article.getType());
            updateLabelTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateArticle(Article article){
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            statement.executeUpdate(
                    "UPDATE blog.article SET " +
                            "intro = " + "\"" + article.getIntro() + "\"" + "," +
                            "md_content = " + "\"" + article.getMdContent() + "\" " + "," +
                            "html_content = " + "\"" + article.getHtmlContent() + "\" " + "," +
                            "title = " + "\"" + article.getTitle() + "\" " + "," +
                            "type = " + "\"" + article.getType() + "\" " + "," +
                            "created_at = " + "\"" + new SimpleDateFormat("yyyy-MM-dd").format(article.getCreatedAt()) + "\" " +
                            "WHERE id = " + article.getId());
            Statement labelStatement = DbUtils.getConnection().createStatement();
            for(String label : article.getLabels()){
                labelStatement.executeUpdate(
                        "UPDATE blog.label SET " + "label = " + "\"" + label + "\"" +
                                " WHERE article_id = " + article.getId() + ";");
            }

            statement.close();
            labelStatement.close();

            AccountManager.getTypes().add(article.getType());
            updateLabelTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteArticle(long id) {
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM blog.label WHERE article_id = " + id);
            statement.executeUpdate("DELETE FROM blog.article WHERE id = " + id);

            statement.close();

            updateTypes();
            updateLabelTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static Article setArticle(ResultSet resultSet){
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

    public static void updateTypes() {
        AccountManager.getTypes().clear();
        Set<String> set = AccountManager.getTypes();
        for(Article article : getAllArticles()) {
            set.add(article.getType());
        }
    }

    public static void updateLabelTypes(){
        AccountManager.getLabelTypes().clear();
        Set<String> labels = AccountManager.getLabelTypes();

        try {
            Statement statement = DbUtils.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blog.label");
            while(resultSet.next()){
                labels.add(resultSet.getString("label"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


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

    private static long getLastArticleId() {
        try {
            Statement statement = DbUtils.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blog.article");
            resultSet.last();
            return resultSet.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return -1;
    }
}
