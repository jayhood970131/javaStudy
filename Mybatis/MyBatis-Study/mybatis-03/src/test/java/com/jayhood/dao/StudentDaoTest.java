package com.jayhood.dao;

import com.jayhood.pojo.Student;
import com.jayhood.pojo.Teacher;
import com.jayhood.utils.MybatisUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {

    //private static Logger logger = Logger.getLogger(StudentDaoTest.class);

    @Test
    public void getStudentsTest() {
        SqlSession session = MybatisUtils.getSqlSession();
        SqlSession session1 = MybatisUtils.getSqlSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> studentsList = mapper.getStudents();
        for (Student stu: studentsList) {
            System.out.println(stu);
        }
        session.close();

        StudentMapper mapper1 = session1.getMapper(StudentMapper.class);
        List<Student> studentsList1 = mapper1.getStudents();
        for (Student stu: studentsList1) {
            System.out.println(stu);
        }
        //session.clearCache();
//        System.out.println("===================================");
//        studentsList = mapper.getStudents();
//        for (Student stu: studentsList) {
//            System.out.println(stu);
//        }

        session1.close();
    }
}
