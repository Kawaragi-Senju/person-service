package ru.person.personservice.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.person.personservice.dto.PersonStreamDTO;
import ru.person.personservice.mapper.PersonMapper;
import ru.person.personservice.repository.PersonRepository;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonConsumerService {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Bean
    public Consumer<PersonStreamDTO> person() {
        return message -> {
            log.info("Received message: {}", message);
            personRepository.save(personMapper.toEntity(message));
        };
    }
}