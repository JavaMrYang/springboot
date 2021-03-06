package com.study.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义BeanDefinitionRegistryPostProcessor接口的实现类
 * 演示BeanDefinitionRegistryPostProcessor & BeanFactoryPostProcessor两个接口的执行时机
 *
 * @author sherman
 */
@Component
public class FooBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * BeanDefinitionRegistryPostProcessor接口的重写方法
     */

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry ---> BeanDefinition Count: " + registry.getBeanDefinitionCount());
        /**
         * 向IOC容器中注册一个Bean
         */
        /*RootBeanDefinition blue = new RootBeanDefinition(Blue.class);
        registry.registerBeanDefinition("blue-copy", blue);
        registry.registerAlias("blue-cpy","blue");*/

        BeanDefinitionBuilder b = BeanDefinitionBuilder.genericBeanDefinition(Blue.class)
                .addPropertyValue("id","001")
                .addPropertyValue("name","张三");
        registry.registerBeanDefinition("blueA",b.getBeanDefinition());
    }

    /**
     * BeanFactoryPostProcessor接口的重写方法
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory ---> BeanDefinition Count: " + beanFactory.getBeanDefinitionCount());
    }
}
