package com.jayhood.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

// 操作数据库的公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        // 通过当前类加载器读取对应的资源
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    // 获取数据库连接
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 编写查询公共类
    public static ResultSet execute(Connection conn, String sql,PreparedStatement preparedStatement,
                                    ResultSet resultSet, Object[] params) throws SQLException {
        preparedStatement = conn.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1,params[i]);
        }
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    // 编写增删改公共类
    public static int execute(Connection conn, String sql,PreparedStatement preparedStatement,
                              Object[] params) throws SQLException {
        preparedStatement = conn.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1,params[i]);
        }

        return preparedStatement.executeUpdate();
    }

    // 关闭连接
    public static boolean closeResource(Connection conn, PreparedStatement preparedStatement,
                                        ResultSet resultSet) {
        boolean flag = true;

        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
            resultSet = null;
        }

        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
            preparedStatement = null;
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
            conn = null;
        }
        return flag;
    }
}
