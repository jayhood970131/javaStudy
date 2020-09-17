package com.jayhood.config;

import com.jayhood.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Retention;

@Configuration
public class JConfig {
    @Bean
    public User getUser() {
        return new User();
    }
}
