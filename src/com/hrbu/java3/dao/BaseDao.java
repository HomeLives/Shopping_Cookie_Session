package com.hrbu.java3.dao;

import Util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Frank
 * @Date: 2020/12/8 18:16
 */
public class BaseDao {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;


    /**
     * 增删改
     *
     * @param sql
     * @param obj
     * @return
     */
    public boolean update(String sql, Object... obj) {
        int count = 0;
        connection = JDBCUtil.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                statement.setObject(i + 1, obj[i]);
            }
            count = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count > 0;
    }

    /**
     * 查
     *
     * @param root
     * @param sql
     * @param obj
     * @param <T>
     * @return
     */
    public <T> List<T> search(Class<T> root, String sql, Object... obj) {
        List<T> list = new ArrayList<T>();
        connection = JDBCUtil.getConnection();
        statement = null;
        resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                statement.setObject(i + 1, obj[i]);
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();

            while (resultSet.next()) {
                T t = root.newInstance();
                Field[] temps = root.getDeclaredFields();
                for (int i = 0; i < temps.length; i++) {
                    temps[i].setAccessible(true);
                    String type = temps[i].getType().getName();
                    /*System.out.println(type);*/
                    if ("int".equals(type) || "java.lang.Integer".equals(type)) {
                        temps[i].set(t, resultSet.getInt(i + 1));
                    } else if ("java.lang.String".equals(type)) {
                        temps[i].set(t, resultSet.getString(i + 1));
                    } else if ("double".equals(type) || "java.lang.Double".equals(type)) {
                        temps[i].set(t, resultSet.getDouble(i + 1));
                    } else if ("java.util.Date".equals(type)) {
                        temps[i].set(t, resultSet.getDate(i + 1));
                    } else if ("float".equals(type) || "java.lang.Float".equals(type)) {
                        temps[i].set(t, resultSet.getDate(i + 1));
                    }
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, statement, connection);
        }
        return list;
    }
}
