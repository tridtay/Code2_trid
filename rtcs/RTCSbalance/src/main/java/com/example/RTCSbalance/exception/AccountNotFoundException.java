package com.example.RTCSbalance.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String name) {
        super(name);
    }
}
