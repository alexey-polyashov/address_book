package ru.mikron.address_book.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mikron.address_book.dto.PersonData;
import ru.mikron.address_book.entity.Person;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface PersonMapper {
    @Mapping(target="managerName", expression = "java(p.getDepartment().getHead().getFullName())")
    @Mapping(target="departmentName", expression = "java(p.getDepartment().getName())")
    @Mapping(target="departmentId", expression = "java(p.getDepartment().getId())")
    PersonData toPersonData(Person p);

}
