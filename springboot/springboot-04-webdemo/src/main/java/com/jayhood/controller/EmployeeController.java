package com.jayhood.controller;

import com.jayhood.dao.DepartmentDao;
import com.jayhood.dao.EmployeeDao;
import com.jayhood.pojo.Department;
import com.jayhood.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("emps", employees);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        System.out.println("save=>" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/emp/update")
    public String toUpdate(@RequestParam("id") Integer id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("emp", employee);
        return "emp/update";
    }

    @PostMapping("/emp/updated")
    public String updateEmployee(Employee employee) {
        System.out.println("save=>" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/emp/delete")
    public String updateEmployee(@RequestParam("id") Integer id) {
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }

}
