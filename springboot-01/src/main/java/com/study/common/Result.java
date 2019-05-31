package com.study.common;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  14:25
 * @Version 1.0
 **/
public class Result<T> {
    private int code;

    private String codeValue;

    private String msg;

    private T t;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String codeValue, String msg) {
        this.code = code;
        this.codeValue = codeValue;
        this.msg = msg;
    }

    public Result(int code, String codeValue, String msg, T t) {
        this.code = code;
        this.codeValue = codeValue;
        this.msg = msg;
        this.t = t;
    }
}
