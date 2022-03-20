package com.example.RTCSbalance.exception;

public class WrongInputException extends RuntimeException{
    public WrongInputException(String name) {
        super(name);
    }
}

