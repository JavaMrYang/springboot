package com.study.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 *
 * @Author LiuYang
 * @Date 2020/11/2/002  9:30
 * @Version 1.0
 **/
public class ApplicationContextInitializerTest implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {


	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("springboot应用是否激活:"+applicationContext.isActive());;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
