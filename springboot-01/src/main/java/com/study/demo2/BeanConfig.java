package com.study.demo2;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/4/004 20:55
 **/
@Configuration
@Import(BeanConfig.User.class)
public class BeanConfig {

    @Bean
    public User registerUser(){
        return new User();
    }


    @Data
    class User{
        private String id;
        private String name;
    }
}
