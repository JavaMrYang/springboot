package com.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LiuYang
 * @Date 2019/5/30/030  19:09
 * @Version 1.0
 * 访问应用程序参数
 **/
@Component
public class ApplicationArgumentsBean {

    /**
     * 注入ApplicationArguments
     * ApplicationArguments接口提供对原始字符串[]参数以及已解析的选项和非选项参数的访问
     * @param args
     */
    @Autowired
    public ApplicationArgumentsBean(ApplicationArguments args){
        boolean debug=args.containsOption("debug");
        List<String> files=args.getNonOptionArgs();
        String[] sourceArgs=args.getSourceArgs();
        for (String str:sourceArgs){
            System.out.println(str);
        }
        System.out.println(debug);
        System.out.println(files);
    }
}
