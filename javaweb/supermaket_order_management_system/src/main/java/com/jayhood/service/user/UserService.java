package com.jayhood.service.user;

import com.jayhood.entity.User;

import java.util.List;

public interface UserService {

    // 获取用户登录信息
    public User login(String userCode,String userPassword);
    // 修改密码
    public boolean saveUserPassword(String oldPassword, String newPassword);
    // 查询记录数
    public int getUserCount(String userName, int userRole);
    // 查询用户列表
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);
    // 删除用户信息
    public boolean deleteUser(int userId);
    // 查看用户信息
    public User viewUser(int userId);
    // 保存用户信息
    public boolean saveUserInfo(User user);
}
