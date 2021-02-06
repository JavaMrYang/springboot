package com.study.mybatis;

import com.alibaba.fastjson.JSON;
import com.study.mybatis.entity.Blog;
import com.study.mybatis.mapper.BlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/6/006 13:28
 **/
@Slf4j
public class MybatisTest01 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session= sqlSessionFactory.openSession(); //打开会话
        BlogMapper blogMapper=session.getMapper(BlogMapper.class);
        Blog blog=blogMapper.selectBlog("1");
        log.debug("blog:{}", JSON.toJSONString(blog));
    }
}
