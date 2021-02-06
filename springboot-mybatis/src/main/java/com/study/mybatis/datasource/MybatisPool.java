package com.study.mybatis.datasource;

import com.study.mybatis.config.DatasourceConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

@AllArgsConstructor
@Slf4j
public class MybatisPool {

    private DatasourceConfig datasourceConfig;

    @Bean
    public PooledDataSource initMybatisPool(){
        PooledDataSource dataSource=new PooledDataSource();
        //log.info("config:{}",JSON.toJSONString(mybatisConfig));
        dataSource.setDriver(datasourceConfig.getDriverClass());
        dataSource.setUsername(datasourceConfig.getUsername());
        dataSource.setUrl(datasourceConfig.getUrl());
        dataSource.setPassword(datasourceConfig.getPassword());
        //log.info("datasource:{}", JSON.toJSONString(dataSource));
        return dataSource;
    }

}
