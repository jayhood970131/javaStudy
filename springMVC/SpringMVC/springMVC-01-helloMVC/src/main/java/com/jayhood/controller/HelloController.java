package com.jayhood.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        // 封装对象
        mv.addObject("msg", "HelloSpirngMVC");
        // 封装要跳转的视图
        mv.setViewName("hello");    // /WEB-INF/jsp/hello.jsp
        return mv;
    }
}
