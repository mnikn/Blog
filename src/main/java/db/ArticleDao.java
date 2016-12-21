package db;

import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/19
 */
public class ArticleDao {
    public static Article getArticle(long id){
        ResultSet resultSet =
                DbUtils.executeQuery("SELECT * FROM blog.article where id = " + id);

        Article article = new Article();
        try {
            while(resultSet.next()){
                article.setId(id);
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setType(resultSet.getString("type"));
                article.setCreatedAt(resultSet.getDate("created_at"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    public static void insertArticle(Article article){
        DbUtils.executeDataChange(
                "INSERT INTO blog.article " +
                        "(content,title,type,created_at)" +
                        "VALUES" + valueString(article));
    }

    public static void updateArticle(Article article){
        DbUtils.executeDataChange(
                "INSERT INTO blog.article " +
                        "(content,title,type,created_at)" +
                        "VALUES" + valueString(article));
    }

    private static String valueString(Article article){
        return "(" +
                article.getContent() +
                "," +
                article.getTitle() +
                "," +
                article.getType() +
                "," +
                article.getCreatedAt()
                + ")";
    }
}
