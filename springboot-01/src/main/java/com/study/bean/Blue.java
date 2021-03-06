package com.study.bean;

import lombok.Data;

/**
 * 演示@Import & ImportSelector进行批量导入
 *
 * @author sherman
 */
@Data
public class Blue {
    private String id;
    private String name;
    public Blue(){
        System.out.println("Blue ctor......");
    }

    public void  initMethod(){
        System.out.println("......我执行了initMethod方法........");
    }
}
