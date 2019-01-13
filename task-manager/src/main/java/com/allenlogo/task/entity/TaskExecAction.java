package com.allenlogo.task.entity;

import lombok.Data;

@Data
public class TaskExecAction {
    private Integer guid;

    private String name;

    private String classPath;

    private String remark;

    public TaskExecAction(){

    }

    public TaskExecAction(Integer guid, String name, String classPath, String remark) {
        this.guid = guid;
        this.name = name;
        this.classPath = classPath;
        this.remark = remark;
    }
}