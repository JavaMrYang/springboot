package com.study.mybatis.datasource;

import com.alibaba.fastjson.JSON;
import com.study.mybatis.config.MybatisConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class MybatisPool {

    private Logger logger= LoggerFactory.getLogger(MybatisPool.class);

    private MybatisConfig mybatisConfig;

    @Bean
    public PooledDataSource initMybatisPool(){
        PooledDataSource dataSource=new PooledDataSource();
        logger.info("datasource:{}", JSON.toJSONString(dataSource));
        dataSource.setDriver(mybatisConfig.getDriverClass());
        dataSource.setUsername(mybatisConfig.getUsername());
        dataSource.setUrl(mybatisConfig.getUrl());
        dataSource.setPassword(mybatisConfig.getPassword());
        return dataSource;
    }
}
