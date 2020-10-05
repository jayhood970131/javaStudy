package com.jayhood.dao;

import com.jayhood.pojo.Department;
import com.jayhood.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employeeMap = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<Integer, Employee>();

        employeeMap.put(1001, new Employee(1001, "AA", "183191342@qq.com", 1, new Department(101,"市场部")));
        employeeMap.put(1002, new Employee(1002, "BB", "191342@qq.com", 0, new Department(102,"体育部")));
        employeeMap.put(1003, new Employee(1003, "CC", "3191342@qq.com", 1, new Department(103,"运维部")));
        employeeMap.put(1004, new Employee(1004, "DD", "1191342@qq.com", 0, new Department(104,"教研部")));
        employeeMap.put(1005, new Employee(1005, "EE", "1191342@qq.com", 1, new Department(105,"教学部")));

    }

    private static Integer initId = 1006;

    // 增加员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employeeMap.put(employee.getId(), employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getEmployees() {
        return employeeMap.values();
    }

    // 通过id查询员工他
    public Employee getEmployeeById(Integer id) {
        return employeeMap.get(id);
    }

    // 删除员工通过Id
    public void deleteEmployee(Integer id) {
        employeeMap.remove(id);
    }


}
