package ru.person.personservice.dto;

import java.sql.Date;
import java.time.LocalDate;

public record PersonStreamDTO(Integer id,
                              String login,
                              String fio,
                              String email,
                              LocalDate date,
                              Date createdOn,
                              Date updatedOn) {
}
