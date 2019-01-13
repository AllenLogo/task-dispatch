package com.allenlogo.task.service;

import com.alibaba.fastjson.JSONObject;
import com.allenlogo.task.dao.TaskInfoMapper;
import com.allenlogo.task.entity.TaskInfo;
import com.allenlogo.task.exception.BusinessException;
import com.allenlogo.task.exception.ExceptionTypeEnum;
import com.allenlogo.task.util.TimeUtil;
import com.allenlogo.task.vo.request.TaskChangeRequest;
import com.allenlogo.task.vo.request.TaskRequest;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TestService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private TaskInfoMapper taskInfoMapper;

    /**
     * 添加新定时任务
     * @param taskRequest
     */
    public void addTask(TaskRequest taskRequest){
        try {
            JobKey jobKey = new JobKey(taskRequest.getCron(),taskRequest.getGroupName());
            if(schedulerFactoryBean.getScheduler().getJobDetail(jobKey)==null){
                startJob(schedulerFactoryBean.getScheduler(),taskRequest.getCron(),taskRequest.getGroupName(),"com.allenlogo.task.job.TestJob",taskRequest.getGuid());
            }else {
                startJob1(schedulerFactoryBean.getScheduler(),taskRequest.getCron(),taskRequest.getGroupName(),taskRequest.getGuid());
            }
        }catch (Exception e){
            throw new BusinessException(ExceptionTypeEnum.TASK_ADD_ERROR);
        }
    }


    /**
     * 启动定时任务
     * @param scheduler
     * @param cron
     * @param className
     * @param id
     * @throws SchedulerException
     */
    private void startJob(Scheduler scheduler,String cron, String gruopName,String className,String id) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        Class<Job> jobClass = null;
        try {
            //实例化具体的Job任务
            jobClass = (Class<Job>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(cron, gruopName).build();
        List<String> gudis = new ArrayList<>();
        gudis.add(id);
        jobDetail.getJobDataMap().put("taskGuid",gudis);
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(cron, gruopName)
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    private void startJob1(Scheduler scheduler,String cron,String gruopName,String id) throws SchedulerException {
        JobKey jobKey = new JobKey(cron,gruopName);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        List<String> guids = ((List<String>)jobDetail.getJobDataMap().get("taskGuid"));
        guids.add(id);
    }

    /**
     * 获取活的任务
     */
    public void getActiveJob(){
        log.info("getActiveJob");
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            for (String groupName : scheduler.getJobGroupNames()) {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();
                    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Date nextFireTime = triggers.get(0).getNextFireTime();
                    Date fireTime = triggers.get(0).getPreviousFireTime();
                    log.info("[jobName] : {} \t [groupName] : {} \t [startTime] : {} \t [nextTime] : {} \t [args] : {}",
                            jobName,jobGroup, TimeUtil.getTimeSDF(TimeUtil.SIMPLE_DATE_FORMAT,fireTime),TimeUtil.getTimeSDF(TimeUtil.SIMPLE_DATE_FORMAT,nextFireTime),JSONObject.toJSONString(jobDetail.getJobDataMap()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeTask(TaskRequest taskRequest){
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobKey jobKey = new JobKey(taskRequest.getCron(), taskRequest.getGroupName());
            if(scheduler.getJobDetail(jobKey)==null){
                throw new BusinessException(ExceptionTypeEnum.TASK_NO_EXIST);
            }else {
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                List<String> guids = ((List<String>)jobDetail.getJobDataMap().get("taskGuid"));
                guids.remove(taskRequest.getGuid());
                if(guids==null || guids.size()==0){
                    scheduler.deleteJob(jobKey);
                }
            }
        }catch (BusinessException e){
            throw e;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException();
        }
    }

    /**
     * 修改任务类型
     * 先删除旧数据，再生成新数据
     * 生成新数据失败，恢复旧数据
     * @param taskChangeRequest
     */
    public void changeTask(TaskChangeRequest taskChangeRequest) {
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setCron(taskChangeRequest.getCronOld());
        taskRequest.setGroupName(taskChangeRequest.getGroupNameOld());
        taskRequest.setGuid(taskChangeRequest.getGuid());
        removeTask(taskRequest);

        taskRequest.setCron(taskChangeRequest.getCron());
        taskRequest.setGroupName(taskChangeRequest.getGroupName());
        try {
            addTask(taskRequest);
        }catch (Exception e){
            taskRequest.setCron(taskChangeRequest.getCronOld());
            taskRequest.setGroupName(taskChangeRequest.getGroupNameOld());
            addTask(taskRequest);
            throw e;
        }
    }

    public void addTaskInfo(String name){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setName(name);
        taskInfoMapper.insert(taskInfo);
    }

    public void selectTaskInfo(Integer guid) {
        log.info("{}",JSONObject.toJSONString(taskInfoMapper.selectByGuid(guid)));
    }
}
