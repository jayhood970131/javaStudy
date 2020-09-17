package com.jayhood.pojo;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public User() {
        System.out.println("午餐构造");
    }

    public User(String name) {
        this.name = name;
        System.out.println("有参构造");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }


}
