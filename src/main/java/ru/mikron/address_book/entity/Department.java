package ru.mikron.address_book.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.mikron.address_book.utility.DataType;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public final class Department {

    @Id
    @GeneratedValue()
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "varchar(255) default 'DEPARTMENT'")
    private DataType dataType;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    @ManyToOne
    private Department parent;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Person> employees;

    @OneToOne
    @JoinColumn(name = "head_id")
    private Person head;
}
