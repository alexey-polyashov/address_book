package ru.mikron.address_book.utility;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum DataType {
    DEPARTMENT("DEP", "Подразделение"), PERSON("P", "Сотрудник");

    private String code;
    private String presentation;

    private DataType(String code, String presentation){
        this.code = code;
    }

    public static DataType of(String code){
        return Stream.of(DataType.values())
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
