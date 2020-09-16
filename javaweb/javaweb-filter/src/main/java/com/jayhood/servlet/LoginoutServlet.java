package com.jayhood.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_session = (String) req.getSession().getAttribute("USER_SESSION");
        if (user_session != null) {
            req.getSession().removeAttribute("USER_SESSION");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
