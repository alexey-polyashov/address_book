package ru.mikron.address_book.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorInfo {
    private String info;
    private String reason;
}
