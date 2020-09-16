package com.jayhood.dao;

import com.jayhood.pojo.Teacher1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Teacher1Mapper {
    List<Teacher1> getTeacher1s();

    Teacher1 getTeacher1(@Param("tid") int id);

    //子查询
    Teacher1 getTeacher2(@Param("fid") int id);
}
