package com.allenlogo.task.entity;

import lombok.Data;

@Data
public class TaskActionTiming {
    private Integer guid;

    private String cron;

    private Integer infoGuid;

    private String infoCode;

    private Integer runServerGuid;

    private Integer execActionGuid;

    public TaskActionTiming(){

    }

    public TaskActionTiming(Integer guid, String cron, Integer infoGuid, String infoCode, Integer runServerGuid, Integer execActionGuid) {
        this.guid = guid;
        this.cron = cron;
        this.infoGuid = infoGuid;
        this.infoCode = infoCode;
        this.runServerGuid = runServerGuid;
        this.execActionGuid = execActionGuid;
    }
}