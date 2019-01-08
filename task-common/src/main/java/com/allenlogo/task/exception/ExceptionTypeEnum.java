package com.allenlogo.task.exception;

import lombok.Getter;

/**
 * 上抛异常枚举
 */
public enum ExceptionTypeEnum {
    /************************ 零、order 相关返回响应吗 900 00 XXX  *****************************/
    CODE_OK(0,"成功"),
    CODE_SYSTEM_ERROR(90000000,"系统繁忙"),
    CODE_SERVER_ERROR(90000001,"服务器异常"),
    CODE_ERROR_PARAM(90000002,"请求参数错误"),;

    @Getter
    private int code;
    @Getter
    private String msg;

    ExceptionTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}