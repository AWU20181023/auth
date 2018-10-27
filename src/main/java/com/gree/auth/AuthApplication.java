package com.gree.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 260152(AWU) on 2018/10/27.
 */
@SpringBootApplication
public class AuthApplication{

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}