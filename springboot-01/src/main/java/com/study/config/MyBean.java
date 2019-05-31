package com.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author LiuYang
 * @Date 2019/5/30/030  18:06
 * @Version 1.0
 **/
/**
声明成一个组件
 */
@Component
public class MyBean {
    /**
     *  注入配置文件中name
     */
    @Value("${name}")
    private String name;

    @Value("${my.random.secret}")
    private String secret;


    public MyBean(){
        System.out.println(this.secret);
    }
    public void testName(){
        System.out.println(name);
        System.out.println(this.secret);
    }
}
