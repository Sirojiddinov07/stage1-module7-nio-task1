package com.epam.mjc.nio;


public class TestFileIncorrectException extends RuntimeException {
    TestFileIncorrectException(String message) {
        super(message);
    }
}