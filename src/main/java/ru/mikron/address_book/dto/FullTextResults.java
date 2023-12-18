package ru.mikron.address_book.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FullTextResults {
    List<FullTextResult> result;
}
