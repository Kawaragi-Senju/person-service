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
//todo 1 создать собственную ошибку для валидации, должна возвращать 400. (указать в хэндлере)
//todo 2 на уровне сервиса проверить чтобы в фио было 3 слова, иначе ошибка из пункта 1.
// так же надо все указать в месседже, информировать какое фио он ввел и что это некорректо и нужно три слова
//посмотреть как работают регулярки не запоминать.
// к собесу, все что мы прошли рассказать вслух себе самому.