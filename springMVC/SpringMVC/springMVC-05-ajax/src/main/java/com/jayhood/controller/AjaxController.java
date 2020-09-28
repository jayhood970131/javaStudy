package com.jayhood.controller;

import com.jayhood.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:name=> " + name);
        if ("admin".equals(name))
            response.getWriter().print(true);
        else
            response.getWriter().print(false);
    }

    @RequestMapping("/a2")
    public List<User> a2() {

        List<User> userList = new ArrayList<User>();
        userList.add(new User("秦疆1号",3,"男"));
        userList.add(new User("秦疆2号",3,"男"));
        userList.add(new User("秦疆3号",3,"男"));
        return userList; //由于@RestController注解，将list转成json格式返回
    }
}
