package com.jayhood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/h1")       // 真实访问地址：项目名/hello/h1
    public String Hello(Model model) {
        model.addAttribute("msg", "hello,springmvc");
        // WEB-INF/jsp/hello.jsp
        return "hello";
    }
}
