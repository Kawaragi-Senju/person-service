package ru.person.personservice.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import ru.person.personservice.service.TestLoggerService;

public class TestLoggerJobService {

    @Autowired
    private TestLoggerService testLoggerService;

    @Scheduled(cron = "${job.test-logger-job.cron}")
    public void run() {
        testLoggerService.testLogger();
    }
}
