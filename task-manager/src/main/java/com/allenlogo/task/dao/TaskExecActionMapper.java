package com.allenlogo.task.dao;

import com.allenlogo.task.entity.TaskExecAction;
import java.util.List;

public interface TaskExecActionMapper {
    int deleteByPrimaryKey(Integer guid);

    int insert(TaskExecAction record);

    TaskExecAction selectByPrimaryKey(Integer guid);

    List<TaskExecAction> selectAll();

    int updateByPrimaryKey(TaskExecAction record);
}