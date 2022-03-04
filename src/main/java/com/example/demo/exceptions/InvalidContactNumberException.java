package com.example.demo.exceptions;

public class InvalidContactNumberException extends Exception {
    public InvalidContactNumberException(String s) {
        super(s);
    }
}