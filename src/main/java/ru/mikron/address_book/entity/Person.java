package ru.mikron.address_book.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mikron.address_book.utility.DataType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @GeneratedValue
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "varchar(255) default 'PERSON'")
    private DataType dataType;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column
    private String tabNumber;

    @Column
    private String fullName;

    @Column
    private String position;

    @Column
    private String phoneNumber;

    @Column
    private String email;
}
