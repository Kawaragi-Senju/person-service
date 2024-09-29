package ru.person.personservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.person.personservice.dto.PersonDTO;
import ru.person.personservice.entity.Person;
import ru.person.personservice.exception.NotFoundException;
import ru.person.personservice.exception.ValidationException;
import ru.person.personservice.mapper.PersonMapper;
import ru.person.personservice.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final String regExp = "^[А-Яа-яЁё]+ [А-Яа-яЁё]+ [А-Яа-яЁё]+$";

    public PersonDTO create(PersonDTO personDTO) {
        if (!personDTO.getFio().matches(regExp)) {
            throw new ValidationException(String.format("Неправильно указанно ФИО = %s, Пример: Экремов Экрем Экремович", personDTO.getFio()));
        }
        return personMapper.toDto(personRepository.save(personMapper.fromDto(personDTO)));
    }

        public PersonDTO getById (Integer id){
            Person person = personRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(String.format("Person with id = %s not found", id)));
            return personMapper.toDto(person);
        }
    }
    //todo сделать валидацию почты как аннотацию