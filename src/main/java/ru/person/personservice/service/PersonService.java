package ru.person.personservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.person.personservice.dto.PersonDTO;
import ru.person.personservice.entity.Person;
import ru.person.personservice.exception.NotFoundException;
import ru.person.personservice.mapper.PersonMapper;
import ru.person.personservice.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonDTO create(PersonDTO personDTO) {
        return personMapper.toDto(personRepository.save(personMapper.fromDto(personDTO)));
    }

    public PersonDTO getById(Integer id){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Person with id = %s not found", id)));
        return personMapper.toDto(person);
    }
}
//
