package com.study.web;


import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  14:40
 * @Version 1.0
 **/

/**
 * 要更改错误处理行为，可以实现ErrorWebExceptionHandler并注册该类型的bean定义。因为WebExceptionHandler是非常底层的，
 * Spring Boot还提供了一个方便的AbstractErrorWebExceptionHandler，让您可以用WebFlux函数的方式处理错误
 */
public class CustomErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {


    public CustomErrorWebExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resourceProperties, applicationContext);
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
       return null;
    }
}
