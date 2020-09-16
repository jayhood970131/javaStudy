package com.jayhood.service.user;

import com.jayhood.entity.User;

public interface UserService {
    public User login(String userCode,String password);
}
