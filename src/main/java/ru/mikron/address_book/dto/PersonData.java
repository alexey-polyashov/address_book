package ru.mikron.address_book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mikron.address_book.entity.Department;

@Getter
@Setter
@NoArgsConstructor
public class PersonData {
    private String tabNumber;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Department department;
}
