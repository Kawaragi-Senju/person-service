package ru.person.personservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.person.personservice.dto.PersonDTO;
import ru.person.personservice.service.PersonService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

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
}
