package ru.mikron.address_book.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public final class Department {

    @Id
    @GeneratedValue()
    @Column(nullable = false)
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    @ManyToOne
    private Department parent;

    @OneToMany
    @JoinColumn(name="department_id")
    private List<Person> employees;

    @OneToOne
    @JoinColumn(name = "head_id")
    private Person head;
}
