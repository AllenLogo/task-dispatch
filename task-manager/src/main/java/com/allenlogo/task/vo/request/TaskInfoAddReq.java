package com.allenlogo.task.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author allenlogo
 * @Date 2019/1/13
 * @Time 22:42
 * To change this template use File | Settings | File Templates.
 */
@Data
@ApiModel("新增任务")
public class TaskInfoAddReq extends BaseRequest {
    @ApiModelProperty("任务名称")
    @NotNull(message = "任务名称不能为空")
    private String name;
    @ApiModelProperty("任务开始日期")
    private String startDate;
    @ApiModelProperty("任务结束日期")
    private String  endDate;
    @ApiModelProperty("任务可执行时间段")
    private String periods;
    @ApiModelProperty("执行脚本")
    @NotNull(message = "执行脚本不能为空")
    private String runScript;
    @ApiModelProperty("备注")
    private String  remark;
    @ApiModelProperty("任务执行器guid")
    @NotNull(message = "执行脚本不能为空")
    private Integer  taskExecActionGuid;
    @ApiModelProperty("任务执行服务器guid")
    @NotNull(message = "执行脚本不能为空")
    private Integer taskServerGuid;

}
