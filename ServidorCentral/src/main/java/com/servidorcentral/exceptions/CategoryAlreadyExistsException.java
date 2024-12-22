package com.servidorcentral.exceptions;

public class CategoryAlreadyExistsException extends Exception {

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }

    public CategoryAlreadyExistsException() {
        super("Category already exists");
    }

}

