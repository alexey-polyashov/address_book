package ru.mikron.address_book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mikron.address_book.entity.Department;

@Getter
@Setter
@NoArgsConstructor
public class PersonData {
    private Long id;
    private String tabNumber;
    private String fullName;
    private String position;
    private String phoneNumber;
    private String email;
    private String managerName;
    private Department departmentName;
    private Department departmentId;
}
