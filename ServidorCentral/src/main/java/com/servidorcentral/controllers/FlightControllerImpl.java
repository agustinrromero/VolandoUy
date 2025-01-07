package com.servidorcentral.controllers;

import com.servidorcentral.dtos.CityDTO;
import com.servidorcentral.dtos.FlightRouteDTO;
import com.servidorcentral.exceptions.CategoryAlreadyExistsException;
import com.servidorcentral.exceptions.CityAlreadyExistsException;
import com.servidorcentral.exceptions.FlightRouteAlreadyExistsException;
import com.servidorcentral.exceptions.UserNotFoundException;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.Category;
import com.servidorcentral.models.City;
import com.servidorcentral.models.FlightRoute;
import com.servidorcentral.models.User;
import com.servidorcentral.repositories.CategoryRepository;
import com.servidorcentral.repositories.CityRepository;
import com.servidorcentral.repositories.FlightRouteRepository;
import com.servidorcentral.repositories.UserRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public Set<String> getCountryNames() {
        CityRepository cityRepository = CityRepository.getInstance();
        return cityRepository.getAllCities().stream()
                .map(each -> each.getCountry().getName())
                .collect(Collectors.toSet());
    }

    @Override
    public void createCategory(Category category) throws CategoryAlreadyExistsException {
        CategoryRepository categoryRepository = CategoryRepository.getInstance();
        categoryRepository.addCategory(category);
    }

    @Override
    public Set<CityDTO> getCitiesFromCountry(String countryName) {
        CityRepository cityRepository = CityRepository.getInstance();
        return cityRepository.getAllCities().stream()
                .filter(each -> each.getCountry().getName().equals(countryName))
                .collect(Collectors.toSet());
    }

    @Override
    public void createFlightRoute(FlightRouteDTO flightRouteDTO) throws FlightRouteAlreadyExistsException, UserNotFoundException {
        FlightRouteRepository flightRouteRepository = FlightRouteRepository.getInstance();
        if (flightRouteRepository.existsFlightRoute(flightRouteDTO.getName())) {
            throw new FlightRouteAlreadyExistsException("Flight route already exists: " + flightRouteDTO.getName());
        }

        FlightRoute flightRoute = new FlightRoute(flightRouteDTO);
        flightRouteRepository.addFlightRoute(flightRoute);

        UserRepository userRepository = UserRepository.getInstance();
        Optional<User> userOptional = userRepository.getUser(flightRouteDTO.getAirline().getUsername());

        Airline airline = (Airline) userOptional.orElseThrow(() ->
                new UserNotFoundException("User " + flightRouteDTO.getAirline().getUsername() + " not found")
        );
    }

}

