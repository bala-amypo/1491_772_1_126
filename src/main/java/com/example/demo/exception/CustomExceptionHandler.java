package com.example.demo.exception;

public class CustomExceptionHandler extends RuntimeException {

    public CustomExceptionHandler(String message) {
        super(message);
    }
}
