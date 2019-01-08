package com.allenlogo.task.controller;

import com.allenlogo.task.exception.BusinessException;
import com.allenlogo.task.exception.ExceptionTypeEnum;
import com.allenlogo.task.vo.response.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller层的基础类
 */
@Slf4j
public class BaseController {

    /**
     * POST请求参数校验异常处理抛出
     * @param result
     * @return
     */
    public MessageResponse parseErrors(BindingResult result) {
        MessageResponse response = new MessageResponse();
        response.setCode(ExceptionTypeEnum.CODE_ERROR_PARAM.getCode());
        String msg = ExceptionTypeEnum.CODE_ERROR_PARAM.getMsg();
        for (ObjectError error : result.getAllErrors()) {
            if (StringUtils.isNoneBlank(error.getDefaultMessage())) {
                msg = error.getDefaultMessage();
                break;
            }
        }
        response.setMsg(msg);
        return response;
    }

    /**
     * service层异常处理抛出
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public MessageResponse handleException(Exception ex) {
        MessageResponse response = new MessageResponse();
        if (ex instanceof BusinessException) {
            BusinessException exception = (BusinessException) ex;
            return exception.getResponse();
        }
        if (ex instanceof IllegalArgumentException) {
            response.setCode(ExceptionTypeEnum.CODE_ERROR_PARAM.getCode());
            response.setMsg(ex.getMessage());
            return response;
        }
        if(ex instanceof MethodArgumentNotValidException){
            return handleMethodArgNotValidExp((MethodArgumentNotValidException) ex);
        }
        log.error("handleException -> System program exception:{}", ex);
        ex.printStackTrace();
        response.setCode(ExceptionTypeEnum.CODE_SYSTEM_ERROR.getCode());
        response.setMsg(ExceptionTypeEnum.CODE_SYSTEM_ERROR.getMsg());
        return response;
    }
    /**
     * 处理参数异常
     * @param ex
     * @return
     */
    public MessageResponse handleMethodArgNotValidExp(MethodArgumentNotValidException ex){
        StringBuilder sb = new StringBuilder("");
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String defaultMessage = error.getDefaultMessage();
            String field = error.getField();
            sb.append(defaultMessage).append("(").append(field);
            Object rejectedValue = error.getRejectedValue();
            if(rejectedValue !=null && !rejectedValue.toString().equals("")){
                sb.append(" = ").append(rejectedValue);
            }
            sb.append(")").append(" ");
        }
        MessageResponse resp = new MessageResponse();
        resp.setCode(ExceptionTypeEnum.CODE_ERROR_PARAM.getCode());
        resp.setMsg(sb.toString());
        return resp;
    }
}
