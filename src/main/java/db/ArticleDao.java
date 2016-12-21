package db;

import model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/19
 */
public class ArticleDao {

    public static final int FIND_BY_TITLE = 0;
    public static final int FIND_BY_TYPE = 1;

    public static Article getArticle(String findText,int flag){
        ResultSet resultSet = null;
        switch (flag){
            case FIND_BY_TITLE:
                resultSet = DbUtils.executeQuery("SELECT * FROM blog.article where title = " + findText);
                break;
            case FIND_BY_TYPE:
                resultSet =  DbUtils.executeQuery("SELECT * FROM blog.article where type = " + findText);
                break;

        }
        return findArticle(resultSet);
    }

    public static void insertArticle(Article article){
        int insertId = DbUtils.executeDataChange(
                "INSERT INTO blog.article " +
                        "(content,title,type,created_at)" +
                        " VALUES " + valueString(article));
        System.out.println("insertId: " + insertId);
//        for(String label : article.getLabels()){
//            DbUtils.executeDataChange(
//                    "INSERT INTO blog.label " +
//                            "(article_id,label) " +
//                            "VALUES " + "(" +
//                            insertId +
//                            "," +
//                            "\"" +
//                            label +
//                            "\"" + ");");
//        }

    }

    private static Article findArticle(ResultSet resultSet){
        Article article = new Article();
        try {
            while(resultSet.next()){
                article.setId(resultSet.getLong("id"));
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

    private static String valueString(Article article){
        return "(" +
                "\"" +
                article.getContent() +
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
