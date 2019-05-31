package com.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author LiuYang
 * @Date 2019/5/30/030  19:16
 * @Version 1.0
 **/

/**
 * 实现CommandLineRunner接口会在调用SpringApplication.run(…​)方法之后回调该方法
 */
@Component
public class CommandLineRunnerBean implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(CommandLineRunnerBean.class);
    @Override
    public void run(String... args) throws Exception {
        logger.info(String.valueOf(args.length));
        logger.info("我在调用SpringApplication.run(…)之后被调用");
    }
}
