package com.study.mybatis.mapper;

import com.study.mybatis.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/6/006 13:38
 **/
@Mapper
public interface BlogMapper {
   public Blog selectBlog(String id);
}
