package com.study.mybatis.dao;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Component
public class SpringbootJdbc implements CommandLineRunner {
    @Autowired
    private PooledDataSource pooledDataSource;


    @Override
    public void run(String... args) throws Exception {
         Connection connection=pooledDataSource.getConnection();
         String sql="select * from user";
         PreparedStatement ps=connection.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
         while (rs.next()){
             ResultSetMetaData metaData=rs.getMetaData();
             int count=metaData.getColumnCount();
             log.info("当前行有{}列",count);
             List<String> cols=new LinkedList<>();
             for(int i=0;i<count;i++){
                 log.info("schemaName:{},colType:{}",metaData.getSchemaName(i+1),metaData.getColumnTypeName(i+1));
                 log.info("catalogName:{},columnLabel:{}",metaData.getCatalogName(i+1),metaData.getColumnLabel(i+1));
                 log.info("tableName:{}",metaData.getTableName(i+1));
                 cols.add(metaData.getColumnName(i+1));

             }
             log.info("cols:{}", JSONObject.toJSONString(cols));
         }
    }
}
