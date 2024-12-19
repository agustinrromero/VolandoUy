package com.servidorcentral.repositories;

import com.servidorcentral.dtos.CityDTO;
import com.servidorcentral.enums.Country;
import com.servidorcentral.exceptions.CityAlreadyExistsException;
import com.servidorcentral.models.City;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CityRepository {

    private static CityRepository instance;
    private final Set<City> cities;

    public static CityRepository getInstance() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }

    private CityRepository() {
        this.cities = new HashSet<>();
    }

    public void addCity(City city) throws CityAlreadyExistsException {
        if (this.cities.contains(city)) {
            throw new CityAlreadyExistsException("City already exists: " + city.getName() + ", " + city.getCountry().getName());
        }

        this.cities.add(city);
    }

    public Optional<City> getCity(String name, Country country) {
        return this.cities.stream()
                .filter(each -> each.getName().equals(name) && each.getCountry() == country)
                .findAny();
    }

    public Set<CityDTO> getAllCities() {
        return this.cities.stream()
                .map(City::getDTO)
                .collect(Collectors.toSet());
    }

}

