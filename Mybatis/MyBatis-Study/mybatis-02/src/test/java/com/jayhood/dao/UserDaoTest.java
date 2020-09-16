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
}
