package com.allenlogo.task.entity;

import lombok.Data;

@Data
public class TaskActionQuta {
    private Integer guid;

    private Integer volume;

    private Integer infoGuid;

    private String infoCode;

    private Integer runServerGuid;

    private Integer execActionGuid;

    public TaskActionQuta(){

    }

    public TaskActionQuta(Integer guid, Integer volume, Integer infoGuid, String infoCode, Integer runServerGuid, Integer execActionGuid) {
        this.guid = guid;
        this.volume = volume;
        this.infoGuid = infoGuid;
        this.infoCode = infoCode;
        this.runServerGuid = runServerGuid;
        this.execActionGuid = execActionGuid;
    }
}