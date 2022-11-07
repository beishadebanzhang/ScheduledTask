package com.example.quartz;

import com.example.quartz.example1.QuartzService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class QuartzApplicationTests {

    @Autowired
    private QuartzService quartzService;

    @Test
    void testAddJob() {
        String className = "com.example.quartz.example1.JobA";
        String groupName = "JobA";
        String cron = "0 * * * * ? *";
        quartzService.addJob(className, groupName, className, groupName, cron);
    }

}
