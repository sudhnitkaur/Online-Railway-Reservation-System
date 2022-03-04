package com.example.demo.exceptions;

public class TrainNotRunningOnThisDayException extends Exception {
    public TrainNotRunningOnThisDayException(String s) {
        super(s);
    }
}