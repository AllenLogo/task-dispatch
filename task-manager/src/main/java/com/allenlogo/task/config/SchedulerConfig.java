package com.allenlogo.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 定时器创建bean
 */
@Configuration
@PropertySource("classpath:quartz.properties")
public class SchedulerConfig {
    @Bean(name = "schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
}
