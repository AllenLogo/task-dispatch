package com.allenlogo.task.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author allenlogo
 * @Date 2019/1/13
 * @Time 22:54
 * To change this template use File | Settings | File Templates.
 */
@Data
public class TIQutaAddReq extends TaskInfoAddReq {
    @ApiModelProperty("任务执行定额数量")
    @Range(min=1, max=100, message = "任务执行定额数量要在1~100")
    private Integer volume;
}
