package com.jayhood.springboot02config.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {

    private Map <String,Object> map;
    @Email
    private String name;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "map=" + map +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

}
