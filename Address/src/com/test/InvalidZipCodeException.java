package com.test;

public class InvalidZipCodeException extends RuntimeException {

    public InvalidZipCodeException(String message) {
        super(message);
    }
}
