package ru.mikron.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikron.address_book.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findAllPerson();
    List<Person> findPersonByEmail(String email);
    List<Person> findPersonByFullName(String name);
    Optional<Person> findPersonById(Long id);

}
