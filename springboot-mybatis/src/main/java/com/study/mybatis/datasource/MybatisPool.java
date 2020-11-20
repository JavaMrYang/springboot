package com.study.mybatis.datasource;

import com.study.mybatis.config.MybatisConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

@AllArgsConstructor
@Slf4j
public class MybatisPool {

    private MybatisConfig mybatisConfig;

    @Bean
    public PooledDataSource initMybatisPool(){
        PooledDataSource dataSource=new PooledDataSource();
        //log.info("config:{}",JSON.toJSONString(mybatisConfig));
        dataSource.setDriver(mybatisConfig.getDriverClass());
        dataSource.setUsername(mybatisConfig.getUsername());
        dataSource.setUrl(mybatisConfig.getUrl());
        dataSource.setPassword(mybatisConfig.getPassword());
        //log.info("datasource:{}", JSON.toJSONString(dataSource));
        return dataSource;
    }
}
