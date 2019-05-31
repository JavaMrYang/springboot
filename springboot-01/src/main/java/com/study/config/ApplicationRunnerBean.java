package com.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author LiuYang
 * @Date 2019/5/30/030  19:19
 * @Version 1.0
 **/
@Component
public class ApplicationRunnerBean implements ApplicationRunner {
    private Logger logger= LoggerFactory.getLogger(ApplicationRunnerBean.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("我也在调用SpringApplication.run(…)之后被调用");
        logger.info("我要比commandLineRunner先调用");
    }
}
