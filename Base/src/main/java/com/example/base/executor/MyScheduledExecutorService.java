package com.example.base.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 该类是JDK1.5自带的类，使用简单，缺点是该方案仅适用于单机环境
 */
public class MyScheduledExecutorService {
    public static void main(String[] args) {
        // 创建任务队列   10 为线程数量
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        // 执行任务
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("打印当前时间：" + new Date());
        }, 1, 3, TimeUnit.SECONDS); // 1s 后开始执行，每 3s 执行一次
    }
}
