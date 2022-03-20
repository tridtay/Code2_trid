package com.example.RTCSbalance.exception;

import javax.naming.AuthenticationException;

public class AccountAlreadyExistAuthenticationException extends AuthenticationException {
    public AccountAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }
}
