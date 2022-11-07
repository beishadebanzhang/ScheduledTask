package com.example.quartz.demo.c1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        Object tv1 = context.getTrigger().getJobDataMap().get("t1");
        Object tv2 = context.getTrigger().getJobDataMap().get("t2");
        Object jv1 = context.getJobDetail().getJobDataMap().get("j1");
        Object jv2 = context.getJobDetail().getJobDataMap().get("j2");

        Object sv = null;
        try {
            sv = context.getScheduler().getContext().get("skey");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        System.out.println(tv1+":"+tv2);
        System.out.println(jv1+":"+jv2);
        System.out.println(sv);
        System.out.println("hello:" + LocalDateTime.now());
    }

    public static void main(String[] args) throws SchedulerException {

        //创建一个scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.getContext().put("skey", "svalue");

        //创建一个Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .usingJobData("t1", "tv1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3)
                .repeatForever()).build();
        trigger.getJobDataMap().put("t2", "tv2");

        //创建一个job detail
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                // schedule每次调度执行任务时, 都会生成一个新的实例, 不会保留job类的属性
                // 使用JobDataMap增加属性或配置、在job的多次执行中，跟踪job的状态
                .usingJobData("j1", "jv1")
                .usingJobData("myJd1", "myJdv1")
                .withIdentity("myjob", "mygroup").build();
        job.getJobDataMap().put("j2", "jv2");

        //注册trigger并启动scheduler
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        // 关闭定时任务
        // scheduler.shutdown();

    }
}
