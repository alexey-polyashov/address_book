package ru.mikron.address_book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mikron.address_book.utility.DataType;

@Getter
@Setter
@NoArgsConstructor
public class FullTextResult {
    private String presentation;
    private String objectTypePresentation;
    private Long uid;
    private DataType dataType;
}
