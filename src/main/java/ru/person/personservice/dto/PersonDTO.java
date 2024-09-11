package ru.person.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class PersonDTO {
    private Integer id;
    private String login;
    private String fio;
    private String email;
    private LocalDate date;
    private Date createdOn;
    private Date updatedOn;
}
