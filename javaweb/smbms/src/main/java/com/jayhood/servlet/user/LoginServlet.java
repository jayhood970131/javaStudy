package com.jayhood.servlet.user;

import com.jayhood.entity.User;
import com.jayhood.service.user.UserServiceImpl;
import com.jayhood.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    // Servlet:控制层, 调用业务层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start...");

        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        // 和数据库中的密码对比
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode,userPassword);

        if(user != null){
            if (user.getUserPassword() == userPassword){    // 判断密码对不对
                // 将用户的信息放到Session中
                req.getSession().setAttribute(Constant.USER_SESSION,user);
                // 跳到主页
                resp.sendRedirect(req.getContextPath() + "/jsp/frame.jsp");
            }
            else {
                // 密码错误,转发回登录页面
                req.setAttribute("error","密码错误");
                req.getRequestDispatcher(  "/login.jsp").forward(req,resp);

            }
        }else { // 查无此人
            // 转发回登录页面
            req.setAttribute("error","用户名错误");
            req.getRequestDispatcher( "/login.jsp").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start...");

        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        // 和数据库中的密码对比
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode,userPassword);

        if(user != null){
            if (user.getUserPassword().equals(userPassword)){    // 判断密码对不对
                // 将用户的信息放到Session中
                req.getSession().setAttribute(Constant.USER_SESSION,user);
                // 跳到主页
                resp.sendRedirect(req.getContextPath() + "/jsp/frame.jsp");
            }
            else {
                // 密码错误,转发回登录页面
                req.setAttribute("error","密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else { // 查无此人
            // 转发回登录页面
            req.setAttribute("error","用户名错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }
    }
}
