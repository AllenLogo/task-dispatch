package com.allenlogo.task.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 新建任务模板
 */
@Data
@ApiModel("修改任务模板")
public class TaskChangeRequest extends BaseRequest {
    @ApiModelProperty("时间表达式")
    @NotNull(message = "时间表示式不能为空")
    private String cron;
    @ApiModelProperty("分组")
    @NotNull(message = "分组不能为空")
    private String groupName;
    @ApiModelProperty("时间表达式-旧")
    @NotNull(message = "时间表示式-旧不能为空")
    private String cronOld;
    @ApiModelProperty("分组-旧")
    @NotNull(message = "分组-旧不能为空")
    private String groupNameOld;
    @ApiModelProperty("任务guid")
    @NotNull(message = "任务guid不能为空")
    private String guid;
}
