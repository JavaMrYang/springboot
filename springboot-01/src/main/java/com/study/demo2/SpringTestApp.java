package com.study.demo2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/4/004 20:51
 **/
@ComponentScan(value = {"com.study.demo2","com.study.bean"})
public class SpringTestApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ac=new AnnotationConfigApplicationContext(BeanConfig.class);
       String[] names= ac.getBeanDefinitionNames(); //获取注册bean的name名称
       for(String name:names){
           System.out.println(name);
       }
    }
}
