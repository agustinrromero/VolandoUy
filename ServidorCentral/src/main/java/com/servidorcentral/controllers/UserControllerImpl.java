package com.servidorcentral.controllers;

import com.servidorcentral.enums.Country;
import com.servidorcentral.enums.IdType;
import com.servidorcentral.exceptions.UserAlreadyExistsException;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.Client;
import com.servidorcentral.models.User;
import com.servidorcentral.repositories.UserRepository;

import java.time.LocalDate;

public class UserControllerImpl implements UserController {

    @Override
    public void createClient(
        String username,
        String name,
        String email,
        String password,
        byte[] image,
        LocalDate registrationDate,
        String lastName,
        LocalDate birthday,
        IdType idType,
        String idNumber,
        Country country
    ) throws UserAlreadyExistsException {
        User newUser = new Client(
            username,
            name,
            email,
            password,
            image,
            registrationDate,
            lastName,
            birthday,
            idType,
            idNumber,
            country
        );

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUser(newUser);
    }

    @Override
    public void createAirline(
        String username,
        String name,
        String email,
        String password,
        byte[] image,
        LocalDate registrationDate,
        String description,
        String webUrl
    ) throws UserAlreadyExistsException {
        User newUser = new Airline(
            username,
            name,
            email,
            password,
            image,
            registrationDate,
            description,
            webUrl
        );

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUser(newUser);
    }

}

