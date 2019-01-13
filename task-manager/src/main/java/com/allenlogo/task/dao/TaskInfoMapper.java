package com.allenlogo.task.dao;

import com.allenlogo.task.entity.TaskInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskInfoMapper {
    int deleteByPrimaryKey(Integer guid);

    int insert(TaskInfo record);

    TaskInfo selectByPrimaryKey(Integer guid);

    List<TaskInfo> selectAll();

    int updateByPrimaryKey(TaskInfo record);

    TaskInfo selectByGuid(@Param("guid")Integer guid);
}