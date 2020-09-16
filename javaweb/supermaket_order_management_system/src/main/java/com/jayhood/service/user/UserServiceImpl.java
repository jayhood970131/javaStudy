package com.jayhood.service.user;

import com.jayhood.dao.BaseDao;
import com.jayhood.dao.user.UserDao;
import com.jayhood.dao.user.UserDaoImpl;
import com.jayhood.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String userPassword) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection,userCode,userPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResources(connection,null,null);
        }
        return user;
    }

    public boolean saveUserPassword(String oldPassword, String newPassword) {
        Connection connection = null;
        boolean isModified = false;
        try {
            connection = BaseDao.getConnection();
            isModified = userDao.saveUserPassword(connection,oldPassword,newPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResources(connection,null,null);
        }
        return isModified;
    }

    public int getUserCount(String userName, int userRole) {
        Connection connection = null;
        int userCount = 0;
        try{
            connection = BaseDao.getConnection();
            userCount = userDao.getUserCount(connection,userName,userRole);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            BaseDao.closeResources(connection,null,null);
        }
        return userCount;
    }

    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList= new ArrayList<User>();
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection,userName,userRole,currentPageNo,pageSize);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            BaseDao.closeResources(connection,null,null);
        }
        return userList;
    }

    public boolean deleteUser(int userId) {
        Connection connection = null;
        boolean isDelete = false;
        try {
            connection = BaseDao.getConnection();
            isDelete = userDao.deleteUser(connection,userId);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            BaseDao.closeResources(connection,null,null);
        }
        return isDelete;
    }

    public User viewUser(int userId) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.viewUser(connection,userId);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            BaseDao.closeResources(connection,null,null);
        }
        return user;
    }

    public boolean saveUserInfo(User user) {
        Connection connection = BaseDao.getConnection();
        boolean isSaved = false;
        try{
            isSaved = userDao.saveUserInfo(connection, user);
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            BaseDao.closeResources(connection, null, null);
        }
        return  isSaved;
    }

//    @Test
//    public void test() {
//        UserServiceImpl userService = new UserServiceImpl();
//        User user = userService.viewUser(14);
//        System.out.println(user.getUserRoleName());
//    }
}
