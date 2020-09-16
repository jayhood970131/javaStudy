package com.jayhood.dao;

import com.jayhood.pojo.User;
import com.jayhood.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static java.sql.Types.NULL;

public class UserDaoTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方法一：getMapper()
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

//        // 方法二：
//        List<User> userList = sqlSession.selectList("com.jayhood.dao.UserDao.getUserList");


        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByID() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserByID(1);
        System.out.println(user);

        sqlSession.close();
    }

    // 增删改查需要提交事务
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            int res = mapper.addUser(new User(16,"zoudafu","邹大福","0000000",1, new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-31"),"18844167036","广东省湛江市霞山区上坡塘",2,1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-08-20 11:11:11"),NULL, null));
            if (res > 0)
                System.out.println("添加成功");
            sqlSession.commit();

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", 16);
            map.put("userCode", "zoudafu");
            map.put("userName", "邹打福");
            map.put("userPassword", "0000000");
            map.put("gender", 1);
            map.put("birthday", new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-31"));
            map.put("phone", "18844167036");
            map.put("address", "广东省湛江市霞山区上坡塘");
            map.put("userRole", 2);
            map.put("createdBy", 1);
            map.put("creationDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-08-20 11:11:11"));
            map.put("modifyBy", NULL);
            map.put("modifyDate", null);

            int res = mapper.addUser2(map);
            if (res > 0)
                System.out.println("添加成功");
            sqlSession.commit();

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            int res =mapper.updateUser(new User(16,"zhoudafu","周大福","0000000",1, new SimpleDateFormat("yyyy-MM-dd").parse("1997-01-31"),"18844167036","广东省湛江市霞山区上坡塘",2,1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-08-20 11:11:11"),NULL, null));
            if (res > 0)
                System.out.println("修改成功");
            sqlSession.commit();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(16);
        if (res > 0)
            System.out.println("删除成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.getUserLike("孙");

        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
