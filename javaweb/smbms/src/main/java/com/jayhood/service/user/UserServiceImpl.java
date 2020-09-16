package com.jayhood.service.user;

import com.jayhood.dao.BaseDao;
import com.jayhood.dao.user.UserDao;
import com.jayhood.dao.user.UserDaoImpl;
import com.jayhood.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    // 业务层都会调用dao层，所以我们要引入Dao层
    private UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;


        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection,userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Test
    public void  test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "1234567");
        System.out.println(admin.getUserPassword());
    }
}
