package com.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;

/**
 * @Author LiuYang
 * @Date 2020/8/7/007  10:27
 * @Version 1.0
 **/
@Slf4j
@Configuration
public class StartEventListenter {

  @Async
  @Order
  @EventListener(WebServerInitializedEvent.class)
  public void afterStart(WebServerInitializedEvent event){
    Environment environment=event.getApplicationContext().getEnvironment();

    //String appName=environment.getProperty("spring.application.name").toUpperCase();
    int localPort=event.getWebServer().getPort();
    String profile= StringUtils.arrayToCommaDelimitedString(environment.getActiveProfiles());

    log.info("------[{}]----启动完成，当前使用的端口:[{}],环境变量:[{}]--",new Object[]{localPort,profile});
  }
}
