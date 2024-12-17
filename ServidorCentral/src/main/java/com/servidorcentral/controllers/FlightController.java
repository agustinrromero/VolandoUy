package com.servidorcentral.controllers;

import com.servidorcentral.exceptions.CityAlreadyExistsException;
import com.servidorcentral.models.City;

public interface FlightController {

    void createCity(City city) throws CityAlreadyExistsException;

}

