package ru.person.personservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
public class TestLoggerService {
    public void testLogger(){
      log.info(LocalDateTime.now().toString());
    }
}
