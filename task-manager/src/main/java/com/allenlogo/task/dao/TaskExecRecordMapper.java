package com.allenlogo.task.dao;

import com.allenlogo.task.entity.TaskExecRecord;
import java.util.List;

public interface TaskExecRecordMapper {
    int deleteByPrimaryKey(Integer guid);

    int insert(TaskExecRecord record);

    TaskExecRecord selectByPrimaryKey(Integer guid);

    List<TaskExecRecord> selectAll();

    int updateByPrimaryKey(TaskExecRecord record);
}