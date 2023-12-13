package ru.mikron.address_book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mikron.address_book.entity.Department;
import ru.mikron.address_book.entity.Person;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentData {
    private String name;
    private Department parent;
    private Person head;
}
