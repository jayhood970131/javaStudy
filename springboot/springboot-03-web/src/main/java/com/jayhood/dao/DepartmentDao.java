package com.jayhood.dao;

import com.jayhood.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentMap = null;


    static {
        departmentMap = new HashMap<Integer, Department>();

        departmentMap.put(101, new Department(101,"市场部"));
        departmentMap.put(102, new Department(102,"体育部"));
        departmentMap.put(103, new Department(103,"运维部"));
        departmentMap.put(104, new Department(104,"教研部"));
        departmentMap.put(105, new Department(105,"教学部"));

    }

    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }

    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }

}
