package com.jayhood.servlet.role;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayhood.entity.Role;
import com.jayhood.service.role.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RoleListServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        PrintWriter writer = resp.getWriter();

        try{
            ObjectMapper om = new ObjectMapper();
            // 将对象列表转化为json对象字符串
            json = om.writeValueAsString(roleList);

            writer.write(json);
            writer.flush();
            writer.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
