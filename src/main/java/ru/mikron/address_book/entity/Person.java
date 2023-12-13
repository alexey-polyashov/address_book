package ru.mikron.address_book.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @GeneratedValue
    @Id
    @Column(name="person_id", nullable = false)
    private Long personId;

    @ManyToOne
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
