package com.allenlogo.task.exception;

import com.allenlogo.task.vo.response.MessageResponse;
import lombok.Data;

/**
 * 业务异常，可上抛，用户可见
 */
@Data
public class BusinessException extends RuntimeException {
    private MessageResponse response;

    public BusinessException() {
        response = new MessageResponse();
        response.setCode(ExceptionTypeEnum.CODE_SERVER_ERROR.getCode());
        response.setMsg(ExceptionTypeEnum.CODE_SERVER_ERROR.getMsg());
    }

    public BusinessException(int code, String msg) {
        super(msg);
        response = new MessageResponse();
        response.setCode(code);
        response.setMsg(msg);
    }
}
