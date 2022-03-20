package com.example.rtcs.exception;

import javax.naming.AuthenticationException;

public class QRcodeCantStore extends AuthenticationException {

    public QRcodeCantStore(final String msg) {
        super(msg);
    }
}
