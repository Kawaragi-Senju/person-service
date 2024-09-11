package ru.person.personservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "person_family_tree", schema = "person_service")
public class PersonFamilyTree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "update_on")
    private Date updatedOn;
}
