package ru.mikron.address_book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mikron.address_book.dto.FullTextResult;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FullTextResults {
    List<FullTextResult> result;
}
