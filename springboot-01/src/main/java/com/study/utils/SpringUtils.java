package com.study.utils;

import com.alibaba.fastjson.JSON;
import com.study.config.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;


/**
 * @Author LiuYang
 * @Date 2020/8/4/004  16:18
 * @Version 1.0
 **/
@Slf4j
public class SpringUtils implements ApplicationContextAware, EmbeddedValueResolverAware {


  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      MyBean myBean=applicationContext.getBean(MyBean.class);
      log.info("myBean:{}", JSON.toJSONString(myBean));
  }

  @Override
  public void setEmbeddedValueResolver(StringValueResolver resolver) {
    log.info("stringValue:{}",resolver.resolveStringValue("hello: ${os.name}" + ", I am #{2571 * 2}"));
  }
}
