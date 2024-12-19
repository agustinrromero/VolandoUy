package com.servidorcentral.controllers;

import com.servidorcentral.exceptions.CityAlreadyExistsException;
import com.servidorcentral.models.City;
import com.servidorcentral.repositories.CategoryRepository;
import com.servidorcentral.repositories.CityRepository;

import java.util.Set;

public class FlightControllerImpl implements FlightController {

    @Override
    public void createCity(City city) throws CityAlreadyExistsException {
        CityRepository cityRepository = CityRepository.getInstance();
        cityRepository.addCity(city);
    }

    @Override
    public Set<String> getAllCategories() {
        CategoryRepository categoryRepository = CategoryRepository.getInstance();
        return categoryRepository.getAllCategories();
    }

}

