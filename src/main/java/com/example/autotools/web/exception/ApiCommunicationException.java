package com.example.autotools.web.exception;

public class ApiCommunicationException extends RuntimeException {
    public ApiCommunicationException(String message, Throwable cause) {
        super(message, cause);
    }
}