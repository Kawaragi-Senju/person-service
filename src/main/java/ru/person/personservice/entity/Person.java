package ru.person.personservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "person", schema = "person_service")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "fio")
    private String fio;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate date;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "update_on")
    private Date updatedOn;
}
