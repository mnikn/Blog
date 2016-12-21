package db;

import java.sql.*;

/**
 * @author zhengzhizhao
 *         Created at 2016/12/19
 */
public class DbUtils {
    private static Connection connection;
    private static Statement statement;
    public static Connection getConnection(){
        if(connection == null){
            String url = "jdbc:mysql://localhost:3306/mysql";
            String name = "mnikn";
            String password = "82193124Mnikn";

            String driver = "com.mysql.jdbc.Driver";
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,name,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static Statement getStatement(){
        if(statement == null){
            try {
                statement = getConnection().createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }

    public static ResultSet executeQuery(String sql){
        ResultSet resultSet = null;
        try {
            resultSet = getStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static int executeDataChange(String sql){
        int changedNum = 0;
        try{
            changedNum = getStatement().executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return changedNum;
    }

}
