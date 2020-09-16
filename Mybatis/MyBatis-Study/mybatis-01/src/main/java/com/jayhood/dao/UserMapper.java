package com.jayhood.dao;

import com.jayhood.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserLike(String value);

    User getUserByID(int id);

    int addUser(User user);

    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}
