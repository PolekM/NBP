package com.example.intern.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MainControllerException.class)
    public ResponseEntity<?> mainControllerBadRequestHandler(MainControllerException mainControllerException) {
        ErrorCode ec = new ErrorCode(mainControllerException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(ec, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NbpControllerException.class)
    public ResponseEntity<?> mainControllerBadRequestHandler(NbpControllerException nbpControllerException) {
        ErrorCode ec = new ErrorCode(nbpControllerException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(ec, HttpStatus.BAD_REQUEST);
    }

}
