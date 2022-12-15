package com.example.intern.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorCode {

    private final String message;
    private final HttpStatus httpStatus;

}
