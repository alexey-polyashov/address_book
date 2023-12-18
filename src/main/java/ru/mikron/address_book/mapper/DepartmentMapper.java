package ru.mikron.address_book.mapper;

import org.mapstruct.Mapper;
import ru.mikron.address_book.dto.DepartmentData;
import ru.mikron.address_book.entity.Department;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, DepartmentMapper.class})
public interface DepartmentMapper {
    DepartmentData toDepartmentData(Department dep);
    Department toDepartment(DepartmentData depData);
}
