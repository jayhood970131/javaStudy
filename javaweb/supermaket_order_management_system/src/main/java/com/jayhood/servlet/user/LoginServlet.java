package com.jayhood.servlet.user;

import com.jayhood.entity.User;
import com.jayhood.service.user.UserServiceImpl;
import com.jayhood.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode,userPassword);

        if (user != null) {             // 是否返回数据库的查询结果
            req.getSession().setAttribute(Constant.USER_SESSION, user);
            resp.getWriter().write(Constant.REDIRECT);
        }
        else {
            resp.getWriter().write("Wrong username or password");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode,userPassword);

        if (user != null) {             // 是否返回数据库的查询结果
            req.getSession().setAttribute(Constant.USER_SESSION, user);
            resp.getWriter().write(Constant.REDIRECT);
        }
        else {
            resp.getWriter().write("Wrong username or password");
        }

    }
}
