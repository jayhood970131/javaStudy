package com.jayhood.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.PrivateKey;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.profiles.active}")
    private String en;

    @Bean
    public Docket docket1() {

        boolean flag = en.equals("dev");
        return new Docket(DocumentationType.SWAGGER_2).groupName("哈哈");
    }

    @Bean
    public Docket docket() {

        boolean flag = en.equals("dev");

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("邹家豪")
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jayhood.controller"))
                //.paths(PathSelectors.ant("/jayhood/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("邹家豪", "https://blog.zou.com/", "183191342@qq.com");
        return new ApiInfo(
                "帅哥",
                "躲在角落看星星",
                "v1.0",
                "https://blog.zou.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

}
