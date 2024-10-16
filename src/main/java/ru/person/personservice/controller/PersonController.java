package ru.person.personservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import ru.person.personservice.consumer.PersonConsumerService;
import ru.person.personservice.dto.PersonDTO;
import ru.person.personservice.dto.PersonStreamDTO;
import ru.person.personservice.entity.Person;
import ru.person.personservice.service.PersonProducerService;
import ru.person.personservice.service.PersonService;

import java.util.function.Consumer;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final PersonProducerService personProducerService;

    @PostMapping
    @Operation(summary = "Create new Person")
    public PersonDTO create(@RequestBody PersonDTO personDTO){
        return personService.create(personDTO);
    }

    @GetMapping("/get-by-id/{id}")
    @Operation(summary = "Give person by id")
    public PersonDTO getById(@PathVariable("id") Integer id){
        return personService.getById(id);
    }

    @PostMapping("/create-with-kafka")
    @Operation(summary = "Create to Kafka")
    public void createKafka(@RequestBody PersonDTO personDTO){
        personProducerService.createToKafka(personDTO);
    }


}
