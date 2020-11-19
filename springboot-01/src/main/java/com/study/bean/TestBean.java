package com.study.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author LiuYang
 * @Date 2020/10/30/030  15:37
 * @Version 1.0
 **/
@Slf4j
public class TestBean implements InitializingBean {

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("我在InitializingBean初始化bean之后初始化");
  }
}
