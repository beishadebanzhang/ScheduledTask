package com.example.elasticjob.demo.ex2.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class TestTask {

    @Scheduled(fixedDelay = 10 * 1000)
    public void getTaskResult() {
      log.info("[getTaskResult] start, time = {}", System.currentTimeMillis());
      try {
          Thread.sleep(3 * 1000);
          log.info("[getTaskResult] get task result success");
      } catch (Exception e) {
          e.printStackTrace();
      }
      log.info("[getTaskResult] end, time = {}", System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 10 * 1000)
    public void createTask() {
        log.info("[createTask] start, time = {}", System.currentTimeMillis());
        try {
            Thread.sleep(3 * 1000);
            log.info("[createTask] create task success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[createTask] end, time = {}", System.currentTimeMillis());
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void generateReport() {
        log.info("[generateReport] start, time = {}", System.currentTimeMillis());
        try {
            Thread.sleep(3 * 1000);
            log.info("[generateReport] generate report success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[generateReport] end, time = {}", System.currentTimeMillis());
    }



}
