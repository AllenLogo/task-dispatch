package com.allenlogo.task.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskInfo {
    private Integer guid;

    private Date createTime;

    private Date updateTime;

    private Integer isDel;

    private Integer isUse;

    private String code;

    private String name;

    private String startDate;

    private String remark;

    private String periods;

    private Integer createGuid;

    private String endDate;

    private String runScript;

    public TaskInfo(){}

    public TaskInfo(Integer guid, Date createTime, Date updateTime, Integer isDel, Integer isUse, String code, String name, String startDate, String remark, String periods, Integer createGuid, String endDate, String runScript) {
        this.guid = guid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDel = isDel;
        this.isUse = isUse;
        this.code = code;
        this.name = name;
        this.startDate = startDate;
        this.remark = remark;
        this.periods = periods;
        this.createGuid = createGuid;
        this.endDate = endDate;
        this.runScript = runScript;
    }
}