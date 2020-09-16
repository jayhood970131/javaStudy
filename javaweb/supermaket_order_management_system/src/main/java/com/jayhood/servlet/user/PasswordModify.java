package com.jayhood.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayhood.entity.User;
import com.jayhood.service.user.UserServiceImpl;
import com.jayhood.utils.Constant;
import com.mysql.cj.xdevapi.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class PasswordModify extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        String json = "{}";
        Map<String, String> resultMap = new HashMap<String, String>();
        if (oldPassword.equals(user.getUserPassword())) { //
            String newPassword = req.getParameter("newPassword");
            if (oldPassword.equals(newPassword)) {
                resultMap.put("result", "same");
            } else {
                UserServiceImpl userService = new UserServiceImpl();
                boolean isModified = userService.saveUserPassword(oldPassword, newPassword);
                if (isModified) {
                    resultMap.put("result", "success");
                    user.setUserPassword(newPassword);
                    req.getSession().setAttribute(Constant.USER_SESSION, user);
                } else {
                    resultMap.put("result", "fail");

                }
            }
        } else {
            resultMap.put("result", "different");
        }
        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            // JSON工具类，转换格式
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(resultMap);
            writer.write(json);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        String json = "{}";
        Map<String, String> resultMap = new HashMap<String, String>();
        if (oldPassword.equals(user.getUserPassword())) { //
            String newPassword = req.getParameter("newPassword");
            if (oldPassword.equals(newPassword)) {
                resultMap.put("result", "same");
            } else {
                UserServiceImpl userService = new UserServiceImpl();
                boolean isModified = userService.saveUserPassword(oldPassword, newPassword);
                if (isModified) {
                    resultMap.put("result", "success");
                    user.setUserPassword(newPassword);
                    req.getSession().setAttribute(Constant.USER_SESSION, user);
                } else {
                    resultMap.put("result", "fail");

                }
            }
        } else {
            resultMap.put("result", "different");
        }
        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            // JSON工具类，转换格式
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(resultMap);
            writer.write(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}