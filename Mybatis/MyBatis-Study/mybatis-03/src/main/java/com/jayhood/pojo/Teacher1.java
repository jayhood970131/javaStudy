package com.jayhood.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher1 {
    private int id;
    private String name;

    private List<Student1> studentList;
}
