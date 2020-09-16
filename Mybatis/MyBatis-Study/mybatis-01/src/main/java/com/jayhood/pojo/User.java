package com.jayhood.pojo;

import org.junit.Test;

import java.util.Date;

public class User {
    private Integer id;         // id
    private String userCode;    // 用户编码
    private String userName;    // 用户名称
    private String userPassword;// 用户密码
    private Integer gender;     // 性别
    private Date birthday;      // 出生日期
    private String phone;       // 电话
    private String address;     // 地址
    private Integer userRole;   // 用户角色（取自角色表-角色id）
    private Integer createdBy;  // 创建者
    private Date creationData;  // 创建时间
    private Integer modifyBy;   // 更新者
    private Date modifyDate;    // 更新时间

    public User() {
    }

    public User(Integer id, String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, Integer userRole, Integer createdBy, Date creationData, Integer modifyBy, Date modifyDate) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationData = creationData;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    private Integer age;
    private String userRoleName;

    public String getUserRoleName() {
        return userRoleName;
    }
    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }
    public Integer getAge() {
        return (new Date().getYear() - birthday.getYear());
    }


    public Integer getId() {
        return id;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Integer getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Date getCreationData() {
        return creationData;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreationData(Date creationData) {
        this.creationData = creationData;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userRole=" + userRole +
                ", createdBy=" + createdBy +
                ", creationData=" + creationData +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", age=" + age +
                ", userRoleName='" + userRoleName + '\'' +
                '}';
    }





}
