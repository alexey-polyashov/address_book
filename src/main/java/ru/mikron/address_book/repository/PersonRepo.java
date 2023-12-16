package ru.mikron.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikron.address_book.entity.Department;
import ru.mikron.address_book.entity.Person;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findAllPerson();
    List<Person> findPersonByEmail(String email);
    List<Person> findPersonByFullName(String name);
    Person findPersonById(Long id);

}
