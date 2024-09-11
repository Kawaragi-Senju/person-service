package ru.person.personservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Configuration;
import ru.person.personservice.dto.PersonDTO;
import ru.person.personservice.entity.Person;

@Configuration
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PersonMapper {
    PersonDTO toDto(Person person);

    Person fromDto(PersonDTO personDTO);
}
