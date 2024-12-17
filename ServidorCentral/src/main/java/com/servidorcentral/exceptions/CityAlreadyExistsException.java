package com.servidorcentral.exceptions;

public class CityAlreadyExistsException extends Exception {

    public CityAlreadyExistsException(String message) {
        super(message);
    }

    public CityAlreadyExistsException() {
        super("City already exists");
    }

}
