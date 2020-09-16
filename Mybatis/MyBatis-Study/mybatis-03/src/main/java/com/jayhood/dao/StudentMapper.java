package com.jayhood.dao;

import com.jayhood.pojo.Student;
import com.jayhood.pojo.Teacher;

import java.util.List;
import java.util.ListResourceBundle;

public interface StudentMapper {
    List<Student> getStudents();
}
