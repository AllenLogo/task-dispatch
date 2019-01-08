package com.allenlogo.task.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("测试请求")
public class TestRequest extends BaseRequest {
    @ApiModelProperty("test")
    @NotNull(message = "参数不能为空")
    private String test;
}
