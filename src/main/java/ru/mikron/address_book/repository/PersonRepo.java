package ru.mikron.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikron.address_book.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

}