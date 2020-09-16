package com.jayhood.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        if(username.equals("admin")) {
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());
            resp.sendRedirect(req.getContextPath() + "/sys/success.jsp");
        }else {
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());

            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}
