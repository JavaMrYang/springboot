package com.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  9:57
 * @Version 1.0
 **/
@Component
public class BannerConfig implements Banner {
    private Logger logger= LoggerFactory.getLogger(BannerConfig.class);
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        //得到环境激活文件
        String[] activeProfiles=environment.getActiveProfiles();
        for (String str:activeProfiles) {
            logger.info(str);
        }
        System.out.println(sourceClass.isArray());
        logger.info("sourceClass:{}",sourceClass.getFields());
        out.print("springboot图标");
    }
}
