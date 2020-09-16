package com.jayhood.servlet.user;

import com.jayhood.entity.User;
import com.jayhood.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.viewUser(Integer.parseInt(userId));
        req.setAttribute("user",user);
        req.getRequestDispatcher("/statics/jsp/userview.jsp").forward(req,resp);
    }
}
