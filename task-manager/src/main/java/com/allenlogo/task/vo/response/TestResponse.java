package com.allenlogo.task.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("测试返回")
public class TestResponse {
    @ApiModelProperty("测试返回字段")
    private String test;
}
