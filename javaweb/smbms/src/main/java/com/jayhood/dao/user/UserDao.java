package com.jayhood.dao.user;

import com.jayhood.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
}
