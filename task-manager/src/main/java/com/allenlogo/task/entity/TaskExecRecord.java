package com.allenlogo.task.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskExecRecord {
    private Integer guid;

    private Integer infoGuid;

    private String infoCode;

    private Date createTime;

    private Date updateTime;

    private Date sendTime;

    private Date receiveTime;

    private Date startTime;

    private Date endTime;

    private String runStatus;

    private String execStatus;

    private Integer runServerGuid;

    private String infoScript;

    public TaskExecRecord(){

    }

    public TaskExecRecord(Integer guid, Integer infoGuid, String infoCode, Date createTime, Date updateTime, Date sendTime, Date receiveTime, Date startTime, Date endTime, String runStatus, String execStatus, Integer runServerGuid, String infoScript) {
        this.guid = guid;
        this.infoGuid = infoGuid;
        this.infoCode = infoCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.runStatus = runStatus;
        this.execStatus = execStatus;
        this.runServerGuid = runServerGuid;
        this.infoScript = infoScript;
    }
}