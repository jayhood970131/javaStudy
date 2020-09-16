package com.jayhood.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class Teacher implements Serializable {
    private int id;
    private String name;
}
