package com.servidorcentral.controllers;

public class Factory {

    private static Factory instance;

    private Factory() {}

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public FlightController getFlightController() {
        return new FlightControllerImpl();
    }

    public UserController getUserController() {
        return new UserControllerImpl();
    }

}

