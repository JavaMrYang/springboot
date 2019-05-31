package com.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  11:16
 * @Version 1.0
 **/
@Configuration
/**
 * profile注解是指定在什么环境下产生作用的注解
 */
@Profile("product")
public class ProductConfiguration {

}
