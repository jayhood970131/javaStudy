package com.jayhood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class EncodingController {


    @PostMapping("/e/t1")
    public String test1(@RequestParam("name") String name, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("msg", name);
        System.out.println(name);
        return "test";
    }
}
