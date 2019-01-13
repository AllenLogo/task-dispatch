package com.allenlogo.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.allenlogo.task.dao")
public class TaskManagerApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(TaskManagerApplication.class).build().run(args);
    }
}
