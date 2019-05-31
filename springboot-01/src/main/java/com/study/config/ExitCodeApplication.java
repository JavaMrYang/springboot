package com.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author LiuYang
 * @Date 2019/5/30/030  19:25
 * @Version 1.0
 **/
@SpringBootApplication
public class ExitCodeApplication {
    private Logger logger= LoggerFactory.getLogger(ExitCodeApplication.class);
    /**
     * 如果希望在调用SpringApplication.exit()时返回特定的退出代码，则使用ExitCodeGenerator接口。
     * 然后可以将此退出代码传递给System.exit()，将其作为状态代码返回
     * @return
     */
    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        logger.info("我在退出的时候调用");
        return ()->42;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(ExitCodeApplication.class,args)));
    }
}
