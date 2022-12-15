package com.example.intern.exception;

public class MainControllerException extends Exception{

    public MainControllerException(String message) {
        super(message);
    }

    public MainControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
