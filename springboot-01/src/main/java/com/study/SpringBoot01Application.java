package com.study;

import com.study.config.BannerConfig;
import com.study.config.MyBean;
import com.study.config.MyTestPropertiries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LiuYang
 * @Date 2019/5/30/030  17:12
 * @Version 1.0
 **/
@RestController
@EnableAutoConfiguration
@SpringBootConfiguration
@ComponentScan
public class SpringBoot01Application {

    private final String HELLO="hello";

    @Autowired
    private MyBean myBean;
    @Autowired
    private  MyTestPropertiries myTestPropertiries;

    @GetMapping("/")
    public String hello(){
        myBean.testName();
        System.out.println(myTestPropertiries.getServers());
        return HELLO+" world";
    }


    public static void main(String[] args) throws Exception{
        //SpringApplication.run(SpringBoot01Application.class,args);
        SpringApplication springApplication=new SpringApplication(SpringBoot01Application.class);
        //关闭启动打印的图标
        //springApplication.setBannerMode(Banner.Mode.OFF);
        //改为自定义打印图标
        springApplication.setBanner(new BannerConfig());
        springApplication.run(args);
    }
}
