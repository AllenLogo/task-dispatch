package com.allenlogo.task.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author allenlogo
 * @Date 2019/1/13
 * @Time 22:58
 * To change this template use File | Settings | File Templates.
 */
@Data
public class TITimingAddReq extends TaskInfoAddReq {
    @ApiModelProperty("cron")
    @NotNull(message = "cron不能为空")
    private String cron;
}
