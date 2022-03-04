package com.example.demo.exceptions;

public class StationNotExistException extends Exception {
    public StationNotExistException(String s) {
        super(s);
    }
}