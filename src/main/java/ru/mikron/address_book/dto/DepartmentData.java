package ru.mikron.address_book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mikron.address_book.entity.Department;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentData {
    private Long id;
    private String name;
    private String code;
    private Department parent;
    private PersonData head;
    List<DepartmentData> subDepartments;
}
