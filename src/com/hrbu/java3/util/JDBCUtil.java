package Util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author Frank
 * @Date: 2020/12/7 0007 下午 1:31
 */
public class JDBCUtil {
    private static Connection connection = null;
    private static Properties pro = null;

    static {
        pro = new Properties();
        try {
            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("JDBCUtil"));
            Class.forName(pro.getProperty("forName"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return connection = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"), pro.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }
}
