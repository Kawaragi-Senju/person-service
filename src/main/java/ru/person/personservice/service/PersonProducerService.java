package ru.person.personservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import ru.person.personservice.dto.PersonDTO;
import ru.person.personservice.dto.PersonStreamDTO;
import ru.person.personservice.mapper.PersonMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonProducerService {
    private final StreamBridge streamBridge;
    private final PersonMapper personMapper;

    public void createToKafka(PersonDTO personDTO) {
        try {
            Message<PersonStreamDTO> message = MessageBuilder.withPayload(personMapper.toStream(personDTO))
                    .build();
            streamBridge.send("person-out-0", message);
            log.info("Headers: {} Payload: {}", message.getHeaders(), message.getPayload());
        } catch (Exception e) {
            log.error("Error", e);
            throw new RuntimeException(e);
        }
    }
}
