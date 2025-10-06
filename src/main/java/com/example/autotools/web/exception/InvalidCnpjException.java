package com.example.autotools.web.exception;

public class InvalidCnpjException extends RuntimeException {
    public InvalidCnpjException(String message) {
        super(message);
    }
}