package com.example.elasticjob.demo.ex1;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;

/**
 * 简单作业:
 *  未经任何封装的类型, 与 Quartz 原生接口相似，但提供了弹性扩缩容和分片等功能
 */
@Slf4j
public class MySimpleJob implements SimpleJob {

    /**
     * shardingContext 包含作业配置、片和运行时信息
     * 可通过getShardingTotalCount(), getShardingItem() 等方法分别获取分片总数，运行在本作业服务器的分片序列号等
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                log.info("我是分片0");
                // do something by sharding item 0
                break;
            case 1:
                log.info("我是分片1");
                // do something by sharding item 1
                break;
            case 2:
                log.info("我是分片2");
                // do something by sharding item 2
                break;
            // case n: ...
        }
    }

}
