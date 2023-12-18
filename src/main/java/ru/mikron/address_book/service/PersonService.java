package ru.mikron.address_book.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikron.address_book.dto.PersonData;
import ru.mikron.address_book.mapper.PersonMapper;
import ru.mikron.address_book.repository.PersonRepo;
import ru.mikron.address_book.exception.NotFoundException;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepo personRepo;
    private final PersonMapper personMapper;

    public PersonData getPersonInfo(Long personId) throws NotFoundException{
        return personMapper.toPersonData(personRepo.findPersonById(personId).orElseThrow(
                ()->new NotFoundException("Person with id " + personId + " not found")));
    }

}
