package com.jayhood.mapper;

import com.jayhood.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUsers();

    public int addUser(User user);

    public int deleteUser(int id);
}
