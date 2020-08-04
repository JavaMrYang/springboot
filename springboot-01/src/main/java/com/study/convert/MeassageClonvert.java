package com.study.convert;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  14:05
 * @Version 1.0
 **/
//@Configuration
public class MeassageClonvert {

    @Bean
    public HttpMessageConverters customConverters() {
        HttpMessageConverter<?> additional = null;
        HttpMessageConverter<?> another = null;
        return new HttpMessageConverters(additional, another);
    }
}
