package com.study.exception;

/**
 * @Author LiuYang
 * @Date 2019/5/31/031  14:23
 * @Version 1.0
 **/
public class BussinessException extends RuntimeException {
    private String code;

    private String msg;

    public BussinessException() {
    }

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
