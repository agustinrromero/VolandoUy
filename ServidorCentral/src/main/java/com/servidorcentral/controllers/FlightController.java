package com.servidorcentral.controllers;

import com.servidorcentral.exceptions.CityAlreadyExistsException;
import com.servidorcentral.models.City;

import java.util.Set;

public interface FlightController {

    void createCity(City city) throws CityAlreadyExistsException;

    Set<String> getAllCategories();

}

