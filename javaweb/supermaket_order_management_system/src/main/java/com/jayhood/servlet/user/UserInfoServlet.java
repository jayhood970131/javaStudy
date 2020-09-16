package com.jayhood.servlet.user;

import com.jayhood.entity.User;
import com.jayhood.service.user.UserServiceImpl;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        if (StringUtils.isNullOrEmpty(id)){
            resp.sendRedirect(req.getContextPath() + "/userList.do");
        }
        else
        {
            UserServiceImpl userService = new UserServiceImpl();
            User user = userService.viewUser(Integer.parseInt(id));
            req.setAttribute("user",user);
            req.getRequestDispatcher("/statics/jsp/usermodify.jsp").forward(req,resp);
        }
    }
}
