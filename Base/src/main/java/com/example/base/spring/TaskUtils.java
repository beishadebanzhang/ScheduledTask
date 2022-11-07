package com.example.base.spring;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskUtils {

    // 添加定时任务
    // todo cron 表达式在线生成地址：https://cron.qqe2.com/
    // todo 多个任务并发执行问题, 启动时执行问题
    // todo 异常处理问题
    @Scheduled(cron = "30 40 23 0 0 5") // cron表达式：每周一 23:40:30 执行
    public void doTask(){
        System.out.println("我是定时任务~");
    }

}
