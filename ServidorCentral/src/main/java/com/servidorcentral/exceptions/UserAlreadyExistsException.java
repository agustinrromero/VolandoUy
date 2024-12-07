package com.servidorcentral.exceptions;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String str) {
        super(str);
    }

    public UserAlreadyExistsException() {
        super("User already exists");
    }

}

