package com.study.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义一个BeanFactoryPostProcessor接口实现类，查看它的创建时机
 *
 * @author sherman
 */
@Component
@Slf4j
public class FooBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("FooBeanFactoryPostProcessor#postProcessBeanFactory()......");
        System.out.println("BeanDefinitionCount: " + beanFactory.getBeanDefinitionCount());
        //beanFactory.registerResolvableDependency();
      /*  final String name="entityBean";
        EntityBean entityBean=new EntityBean();
        beanFactory.registerSingleton(name,entityBean);
        log.info("我注册一个bean:{}",beanFactory.getBean(name).toString());
        *//*for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }*//*
        beanFactory.destroyScopedBean(name);
        log.info("我销毁之后的bean:{}",beanFactory.getBean(name).toString());*/
        System.out.println("================end================");
    }
}
