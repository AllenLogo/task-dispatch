package com.allenlogo.task.dao;

import com.allenlogo.task.entity.TaskActionTiming;
import java.util.List;

public interface TaskActionTimingMapper {
    int deleteByPrimaryKey(Integer guid);

    int insert(TaskActionTiming record);

    TaskActionTiming selectByPrimaryKey(Integer guid);

    List<TaskActionTiming> selectAll();

    int updateByPrimaryKey(TaskActionTiming record);
}