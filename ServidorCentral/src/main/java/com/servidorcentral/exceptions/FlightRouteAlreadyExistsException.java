package com.servidorcentral.exceptions;

public class FlightRouteAlreadyExistsException extends Exception {

    public FlightRouteAlreadyExistsException(String message) {
        super(message);
    }

    public FlightRouteAlreadyExistsException() {
        super("Flight route already exists");
    }

}
