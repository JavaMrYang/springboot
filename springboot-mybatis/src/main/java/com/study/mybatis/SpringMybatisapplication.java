package com.study.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("dev")
public class SpringMybatisapplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisapplication.class,args);
    }
}
