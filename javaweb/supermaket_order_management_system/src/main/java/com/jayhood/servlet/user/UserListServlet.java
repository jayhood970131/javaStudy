package com.jayhood.servlet.user;

import com.jayhood.entity.Role;
import com.jayhood.entity.User;
import com.jayhood.service.role.RoleServiceImpl;
import com.jayhood.service.user.UserServiceImpl;
import com.jayhood.utils.PageSupport;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("queryUserName");
        String userRole = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");

        int queryUserRole = 0;
        int currentPageNo = 1;
        int totalCount = 0;
        int pageSize = 5;   // 可以把这个放到配置文件中
        int totalPageCount = 1;
        List<User> userList = null;

        UserServiceImpl userService = new UserServiceImpl();
        RoleServiceImpl roleService = new RoleServiceImpl();

        if (userName == null){
            userName = "";
        }
        if (!StringUtils.isNullOrEmpty(userRole)){
            queryUserRole = Integer.parseInt(userRole);
        }
        if (!StringUtils.isNullOrEmpty(pageIndex)){
            currentPageNo = Integer.parseInt(pageIndex);
        }


        // 获取用户总数
        totalCount = userService.getUserCount(userName, queryUserRole);
        totalPageCount = (totalCount - 1) / pageSize + 1;
        //
//        PageSupport pageSupport = new PageSupport();
//        pageSupport.setCurrentPageNo(currentPageNo);
//        pageSupport.setPageSize(pageSize);
//        pageSupport.setTotalCount(totalCount);
//
//        int totalPageCount = pageSupport.getTotalPageCount();

        // 获取用户列表展示
        userList = userService.getUserList(userName, queryUserRole, currentPageNo, pageSize);

        // 获取角色列表
        List<Role> roleList = roleService.getRoleList();

        // 设置request属性返回给前端
        req.setAttribute("userList",userList);
        req.setAttribute("roleList",roleList);

        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("userName",userName);
        req.setAttribute("userRole",queryUserRole);

        req.getRequestDispatcher("/statics/jsp/userlist.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("queryUserName");
        String userRole = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");

        int queryUserRole = 0;
        int currentPageNo = 1;
        int totalCount = 0;
        int pageSize = 5;   // 可以把这个放到配置文件中
        int totalPageCount = 1;
        List<User> userList = null;

        UserServiceImpl userService = new UserServiceImpl();
        RoleServiceImpl roleService = new RoleServiceImpl();

        if (userName == null){
            userName = "";
        }
        if (!StringUtils.isNullOrEmpty(userRole)){
            queryUserRole = Integer.parseInt(userRole);
        }
        if (!StringUtils.isNullOrEmpty(pageIndex)){
            currentPageNo = Integer.parseInt(pageIndex);
        }


        // 获取用户总数
        totalCount = userService.getUserCount(userName, queryUserRole);
        totalPageCount = (totalCount - 1) / pageSize + 1;
        //
//        PageSupport pageSupport = new PageSupport();
//        pageSupport.setCurrentPageNo(currentPageNo);
//        pageSupport.setPageSize(pageSize);
//        pageSupport.setTotalCount(totalCount);
//
//        int totalPageCount = pageSupport.getTotalPageCount();

        // 获取用户列表展示
        userList = userService.getUserList(userName, queryUserRole, currentPageNo, pageSize);

        // 获取角色列表
        List<Role> roleList = roleService.getRoleList();

        // 设置request属性返回给前端
        req.setAttribute("userList",userList);
        req.setAttribute("roleList",roleList);

        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("userName",userName);
        req.setAttribute("userRole",queryUserRole);

        req.getRequestDispatcher("/statics/jsp/userlist.jsp").forward(req,resp);


    }
}
