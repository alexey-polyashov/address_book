package ru.mikron.address_book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.mikron.address_book.dto.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHundler {
    @ExceptionHandler(value
            = NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handlerNotFoundException(Exception e){
        return ErrorInfo.builder()
                .info(e.getMessage())
                .build();
    }

}
