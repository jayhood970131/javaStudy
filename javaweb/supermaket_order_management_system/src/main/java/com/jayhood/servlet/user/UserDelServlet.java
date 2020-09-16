package com.jayhood.servlet.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayhood.service.user.UserServiceImpl;
import com.jayhood.utils.Constant;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("userId");
        Map<String,String> mapResult= new HashMap<String,String>();
        String json = "{}";
        if (StringUtils.isNullOrEmpty(userIdStr)){
            mapResult.put(Constant.DELRESULT,"notExist");
        }
        else {
            UserServiceImpl userService = new UserServiceImpl();
            int userId = Integer.parseInt(userIdStr);
            boolean isDelete = userService.deleteUser(userId);
            if (isDelete){  //如果删除成功
                mapResult.put(Constant.DELRESULT,"true");
            }
            else {
                mapResult.put(Constant.DELRESULT,"false");
            }
        }
        try{
            resp.setContentType("application/json");
            PrintWriter printWriter = resp.getWriter();
            // JSON工具类，转换格式
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(mapResult);
            printWriter.write(json);
            printWriter.flush();
            printWriter.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
