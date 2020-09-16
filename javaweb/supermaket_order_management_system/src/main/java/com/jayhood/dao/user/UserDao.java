package com.jayhood.dao.user;

import com.jayhood.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException;

    // 修改当前用户密码
    public boolean saveUserPassword(Connection connection, String oldPassword, String newPassword) throws SQLException;

    // 查询用户总数
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException;

    // 获取用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException;

    // 删除用户
    public boolean deleteUser(Connection connection, int userId) throws SQLException;

    // 查看单个用户
    public User viewUser(Connection connection, int userId) throws SQLException;

    // 保存用户信息
    public boolean saveUserInfo(Connection connection, User user) throws SQLException;
}
