package com.allenlogo.task.entity;

import lombok.Data;

@Data
public class TaskServer {
    private Integer guid;

    private String name;

    private String ip;

    private String port;

    private String remark;

    public TaskServer(){

    }

    public TaskServer(Integer guid, String name, String ip, String port, String remark) {
        this.guid = guid;
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.remark = remark;
    }
}