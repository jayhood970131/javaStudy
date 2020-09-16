package com.jayhood.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String userName = req.getParameter("userName");
        String genderStr = req.getParameter("gender");
        String birthdayStr = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRoleStr = req.getParameter("userRole");

        int id = Integer.parseInt(idStr);
        int gender = Integer.parseInt(genderStr);
    }
}
