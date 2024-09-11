package ru.person.personservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.person.personservice.entity.PersonFamilyTree;

@Repository
public interface PersonFamilyTreeRepository extends JpaRepository<PersonFamilyTree, Integer> {
}
