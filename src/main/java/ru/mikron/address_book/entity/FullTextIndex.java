package ru.mikron.address_book.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mikron.address_book.utility.DataType;

@Entity
@NoArgsConstructor
@Data
public class FullTextIndex {

    @Id
    @GeneratedValue()
    @Column(nullable = false)
    private Long id;

    @Column
    private String text;

    private DataType dataType;

    @Column
    private Long uid;

    @Column
    private String presentation;

}
