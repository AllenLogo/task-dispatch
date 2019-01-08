package com.allenlogo.task.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public void addTask(String id) throws SchedulerException {
        startJob(schedulerFactoryBean.getScheduler(),id,"0/5 * * * * ?","com.allenlogo.task.job.TestJob",id);
    }

    private void startJob(Scheduler scheduler, String name, String cron, String className,String id) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        Class<Job> jobClass = null;
        try {
            //实例化具体的Job任务
            jobClass = (Class<Job>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(name, "group1").build();
        jobDetail.getJobDataMap().put("taskGuid",id);
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(name, "group1")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
