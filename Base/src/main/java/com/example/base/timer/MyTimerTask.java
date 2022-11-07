package com.example.base.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 优点是使用简单, 缺点是当添加并执行多个任务时, 前面任务的执行用时和异常将影响到后面任务
 */
public class MyTimerTask {
    public static void main(String[] args) {
        // 定义一个任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("打印当前时间: " + new Date());
            }
        };

        /**
         * 计时器
         *  主要用于维护定时任务，管理任务的执行
         *  当实例化一个Timer对象的时候，这时新建了一个TaskQueue任务队列并且新建了一个线程
         *  任务队列主要存放待执行的任务，线程主要负责管理待执行的任务
         */
        Timer timer = new Timer();
        // 开始执行任务 (延迟1000毫秒执行，每3000毫秒执行一次)
        timer.schedule(timerTask, 1000, 3000);
    }
}
