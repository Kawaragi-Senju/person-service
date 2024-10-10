package ru.person.personservice.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.person.personservice.job.TestLoggerJobService;

@Configuration
@EnableScheduling
public class ScheduleConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "job.test-logger-job",value = "enabled",matchIfMissing = true, havingValue = "true")
    public TestLoggerJobService testLoggerJobService() {
        return new TestLoggerJobService();
    }
}
