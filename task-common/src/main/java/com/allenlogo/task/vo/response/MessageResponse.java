package com.allenlogo.task.vo.response;

import com.allenlogo.task.exception.BusinessException;
import com.allenlogo.task.exception.ExceptionTypeEnum;
import com.allenlogo.task.util.TimeUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;

/**
 * 统一的请求响应
 * @param <T>
 */
@ApiModel(value = "MessageResponse")
@Data
public class MessageResponse<T> {
    private static Gson seriaGson = null;
    private static GsonBuilder gsonBuilder = new GsonBuilder();

    static {
        gsonBuilder.setPrettyPrinting()
                .disableHtmlEscaping()
                // .serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss");
        seriaGson = gsonBuilder.create();
    }

    public MessageResponse() {
    }

    public MessageResponse(T data) {
        this.data = data;
    }

    @ApiModelProperty(value = "状态码")
    private int code = ExceptionTypeEnum.CODE_OK.getCode();
    @ApiModelProperty(value = "状态信息")
    private String msg = ExceptionTypeEnum.CODE_OK.getMsg();
    @ApiModelProperty(value = "返回数据")
    private T data;
    @ApiModelProperty(value = "响应时间")
    private String time = TimeUtil.getCurrentTime(TimeUtil.SIMPLE_DATE_FORMAT);

    @Override
    public String toString(){
        return seriaGson.toJson(this);
    }

    public boolean checkData(){
        boolean b = code == ExceptionTypeEnum.CODE_OK.getCode() && Objects.nonNull(data);
        if(b){
            return true;
        }
        throw new BusinessException(code,msg);
    }

    public boolean checkError(){
        boolean b = code == ExceptionTypeEnum.CODE_OK.getCode();
        if(b) {
            return true;
        }
        throw new BusinessException();
    }
}
