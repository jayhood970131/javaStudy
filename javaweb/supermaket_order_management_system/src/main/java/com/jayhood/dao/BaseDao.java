package com.jayhood.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String url;     // 数据库连接语句
    private static String driver;  // 数据库驱动
    private static String username;    // 连接数据库的用户名
    private static String password;    // 连接数据库的密码

    static {
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    // 获取数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 查询公共类
    public static ResultSet execute(Connection connection, PreparedStatement pstm, ResultSet rs, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++){
            pstm.setObject(i + 1, params[i]);
        }
        rs = pstm.executeQuery();
        return rs;
    }

    // 增删改公共类
    public static int execute(Connection connection, PreparedStatement pstm, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++){
            pstm.setObject(i + 1, params[i]);
        }
        int updateRows = pstm.executeUpdate();
        return updateRows;
    }

    // 关闭连接
    public static boolean closeResources(Connection connection, PreparedStatement pstm, ResultSet rs) {
        boolean flag = true;
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag =false;
            }
            rs = null;
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag =false;
            }
            pstm = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag =false;
            }
            connection = null;
        }
        return flag;
    }
}
