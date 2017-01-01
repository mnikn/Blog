package db;

import java.sql.*;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/25
 */
public class DbUtils {
    private static Connection connection;
    private static Statement statement;

    static {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String name = "mnikn";
        String password = "82193124Mnikn";

        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url +
                    "?user=" + name +
                    "&password=" + password +
                    "&useUnicode=true&characterEncoding=utf-8");
            statement = getConnection().createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }

}
