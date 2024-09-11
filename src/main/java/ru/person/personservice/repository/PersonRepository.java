package ru.person.personservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.person.personservice.dto.PersonDTO;
import ru.person.personservice.entity.Person;
import ru.person.personservice.projection.PersonInfo;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findPersonByLogin(String login); //искать по логину, выдает персона

    List<Person> findAllByFio(String fio);

    Person findByDate(LocalDate date);

    List<Person> findAllByLoginIn(List<String> listOfLogins);

//    @Query("""
//            SELECT p
//            FROM Person p
//            JOIN PersonFamilyTree pft ON pft.userId = p.id
//            WHERE pft.parentId = :parentId
//            """)
//    Person findPersonByParentId(@Param("parentId") Integer parentId);
//
//    @Query("""
//            SELECT new ru.person.personservice.dto.PersonDTO(p.id, p.login, p.fio, p.email, p.date, p.createdOn, p.updatedOn )
//            FROM Person p
//            JOIN PersonFamilyTree perFT ON perFT.userId = p.id
//            WHERE perFT.parentId = :parId
//            """)
//    PersonDTO findPersonDTOByParentId(@Param("ParId") Integer parId);
//
//    @Query("""
//            SELECT p.id AS id,
//             p.login AS login,
//             p.email AS email,
//             p.date AS date,
//             p.createdOn AS createdOn,
//             p.updatedOn AS updatedOn
//            FROM Person p
//            JOIN PersonFamilyTree pftree ON pftree.userId = p.id
//            WHERE pftree.parentId = :parId
//            """)
//    PersonInfo findPersonInfoByParentId(@Param("parId") Integer parId);
}

//ALIAS - запомнить
//1 - Опеределяем алиас
//2 - Понять по какому полю соединять таблицы