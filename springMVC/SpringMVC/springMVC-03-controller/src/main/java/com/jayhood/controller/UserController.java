package com.jayhood.controller;

import com.jayhood.pojo.User;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        // 接收前端参数
        System.out.println("接收到前端的参数为：" + name);

        model.addAttribute("msg", name);

        return "test";
    }

    @GetMapping("/t2")
    public String test2(User user) {
        System.out.println(user);
        return "test";
    }



}
