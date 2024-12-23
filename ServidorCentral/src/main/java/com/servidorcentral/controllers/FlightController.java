package com.servidorcentral.controllers;

import com.servidorcentral.dtos.CityDTO;
import com.servidorcentral.exceptions.CategoryAlreadyExistsException;
import com.servidorcentral.exceptions.CityAlreadyExistsException;
import com.servidorcentral.models.Category;
import com.servidorcentral.models.City;

import java.util.Set;

public interface FlightController {

    void createCity(City city) throws CityAlreadyExistsException;

    Set<String> getAllCategories();

    /**
     * Get all country names that have a city registered
     * @return Set of country names
     */
    Set<String> getCountryNames();

    void createCategory(Category category) throws CategoryAlreadyExistsException;

    Set<CityDTO> getCitiesFromCountry(String countryName);

}

