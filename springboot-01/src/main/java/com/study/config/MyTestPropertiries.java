package com.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  10:48
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "mytest")
public class MyTestPropertiries {
    private List<String> servers=new ArrayList<>();

    public List<String> getServers(){
        return this.servers;
    }
}
