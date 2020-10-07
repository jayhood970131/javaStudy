package com.jayhood.service;

import com.jayhood.mapper.UserMapper;
import com.jayhood.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;

    @Override
    public User queryUserByName(String name) {
        return mapper.queryUserByName(name);
    }
}
