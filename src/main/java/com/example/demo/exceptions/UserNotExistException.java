package com.example.demo.exceptions;

public class UserNotExistException extends Exception {
    public UserNotExistException(String s) {
        super(s);
    }
}