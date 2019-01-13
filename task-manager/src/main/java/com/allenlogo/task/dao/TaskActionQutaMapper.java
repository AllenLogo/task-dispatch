package com.allenlogo.task.dao;

import com.allenlogo.task.entity.TaskActionQuta;
import java.util.List;

public interface TaskActionQutaMapper {
    int deleteByPrimaryKey(Integer guid);

    int insert(TaskActionQuta record);

    TaskActionQuta selectByPrimaryKey(Integer guid);

    List<TaskActionQuta> selectAll();

    int updateByPrimaryKey(TaskActionQuta record);
}