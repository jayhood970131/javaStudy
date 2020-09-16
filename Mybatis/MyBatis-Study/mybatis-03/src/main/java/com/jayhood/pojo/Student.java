package com.jayhood.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class Student implements Serializable {
    private int id;
    private String name;
    private Teacher teacher;

}
