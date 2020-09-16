package com.jayhood.dao;

import com.jayhood.pojo.Teacher1;
import com.jayhood.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class Teacher1DaoTest {
    private static Logger logger = Logger.getLogger(Teacher1DaoTest.class);
    @Test
    public void getTeacher1s() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Teacher1> teacher1s = sqlSession.getMapper(Teacher1Mapper.class).getTeacher1s();
        for (Teacher1 teacher1:
             teacher1s) {
            System.out.println(teacher1);
        }
        sqlSession.close();
    }
    
    @Test
    public void getTeacher1() {
        SqlSession session = MybatisUtils.getSqlSession();
        Teacher1Mapper mapper = session.getMapper(Teacher1Mapper.class);
        Teacher1 teacher1 = mapper.getTeacher1(1);
        System.out.println(teacher1);
        session.close();
    }

    @Test
    public void getTeacher2() {
        SqlSession session = MybatisUtils.getSqlSession();
        Teacher1Mapper mapper = session.getMapper(Teacher1Mapper.class);
        Teacher1 teacher1 = mapper.getTeacher2(1);
        System.out.println(teacher1);
        session.close();
    }
}
