package com.study.app;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/2/5/005 17:50
 **/
public class HashSetTest {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add("ss");
        set.add("ss");
        System.out.println(JSON.toJSON(set));
    }
}
