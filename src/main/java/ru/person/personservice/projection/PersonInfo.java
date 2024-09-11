package ru.person.personservice.projection;

import java.sql.Date;
import java.time.LocalDate;

public interface PersonInfo {
    Integer getId();
    String getLogin();
    String gerFio();
    String getEmail();
    LocalDate getDate();
    Date getCreatedOn();
    Date getUpdatedBy();
}