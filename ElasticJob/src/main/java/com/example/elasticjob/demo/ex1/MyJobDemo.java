package com.example.elasticjob.demo.ex1;

import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

public class MyJobDemo {

    public static void main(String[] args) {
        new ScheduleJobBootstrap(createRegistryCenter(), new MySimpleJob(), createJobConfiguration()).schedule();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
                new ZookeeperConfiguration("zk_host:2181", "my-job"));
        regCenter.init();
        return regCenter;
    }

    private static JobConfiguration createJobConfiguration() {
        // 创建作业配置
        // ...
        JobConfiguration jobConfig = JobConfiguration
                .newBuilder("MyJob", 3)
                .cron("0/5 * * * * ?")
                .build();
        return jobConfig;
    }


}
