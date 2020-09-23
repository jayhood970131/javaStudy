package com.jayhood.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayhood.pojo.User;
import com.jayhood.utils.JsonUtils;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController // 不走视图解析器
public class UserController {

    // springmvc里面配置了json乱码解放方法,就不用这个了
    //@RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
    // 如果用了@RestController，就不同@ResponseBody了
    //@ResponseBody // 不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        User user = new User(18, "zou", "男");
        return JsonUtils.getJson(user);
    }

    @RequestMapping("/j2")
    // 如果用了@RestController，就不同@ResponseBody了
    //@ResponseBody // 不会走视图解析器，会直接返回一个字符串
    public String json2() throws JsonProcessingException {
        Date date = new Date();
        ObjectMapper mapper = new ObjectMapper();

        // 时间解析后得默认格式为： Timestamp
        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/j3")
    // 如果用了@RestController，就不同@ResponseBody了
    //@ResponseBody // 不会走视图解析器，会直接返回一个字符串
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 时间解析后得默认格式为： Timestamp
        return mapper.writeValueAsString(simpleDateFormat.format(date));
    }

    @RequestMapping("/j4")
    // 如果用了@RestController，就不同@ResponseBody了
    //@ResponseBody // 不会走视图解析器，会直接返回一个字符串
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date, "yyyy-MM-dd hh:mm:ss");
    }

    @RequestMapping("/j5")
    public String json5() {
        List<User> userList = new ArrayList<User>();
        User user1 = new User(18, "邹走走", "男");
        User user2 = new User(18, "秦亲亲", "女");
        userList.add(user1);
        userList.add(user2);

        return JSON.toJSONString(userList);
    }

}
