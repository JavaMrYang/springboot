package com.example.springbootredis;

import com.example.springbootredis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching //开启缓存
@SpringBootApplication
public class SpringbootRedisApplication {
    @Autowired
    private RedisTemplate redisTemplate;

    private void init(){
        //redisTemplate.
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }
}
