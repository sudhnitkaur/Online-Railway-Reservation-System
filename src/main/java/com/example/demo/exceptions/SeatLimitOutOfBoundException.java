package com.example.demo.exceptions;

public class SeatLimitOutOfBoundException extends Exception {
    public SeatLimitOutOfBoundException(String s) {
        super(s);
    }
}