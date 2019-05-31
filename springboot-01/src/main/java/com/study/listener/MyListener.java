package com.study.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  10:07
 * @Version 1.0
 **/

/**
 * 监听器的使用
 */
public class MyListener  implements ApplicationListener {
    public MyListener(){
        System.out.println("====myListener execute=====");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        /*AnnotationConfigServletWebServerApplicationContext springApplication= (AnnotationConfigServletWebServerApplicationContext) applicationEvent.getSource();
        System.out.println(springApplication.getApplicationName());*/
        System.out.println(applicationEvent.getSource());
        System.out.println("====myListener onApplicationEvent execute=====");
    }
}
