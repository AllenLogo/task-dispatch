package com.allenlogo.task.dao;

import com.allenlogo.task.entity.TaskServer;
import java.util.List;

public interface TaskServerMapper {
    int deleteByPrimaryKey(Integer guid);

    int insert(TaskServer record);

    TaskServer selectByPrimaryKey(Integer guid);

    List<TaskServer> selectAll();

    int updateByPrimaryKey(TaskServer record);
}