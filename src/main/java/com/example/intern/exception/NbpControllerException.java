package com.example.intern.exception;

public class NbpControllerException extends Exception {

    public NbpControllerException(String message){
        super(message);
    }

    public NbpControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
