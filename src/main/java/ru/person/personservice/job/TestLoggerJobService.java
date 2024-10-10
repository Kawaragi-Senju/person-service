package ru.person.personservice.job;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.person.personservice.service.TestLoggerService;

@Service
@RequiredArgsConstructor
public class TestLoggerJobService {

    private final TestLoggerService testLoggerService;

    @Scheduled(cron = "15 * * * * *")
    public void run(){
        testLoggerService.testLogger();
    }

}
