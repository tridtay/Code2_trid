package com.example.rtcs.exception;

public class QRcodeNotFoundException extends RuntimeException{
    public QRcodeNotFoundException(String name) {
        super(name);
    }
}
