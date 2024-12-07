package com.servidorcentral.controllers;

import com.servidorcentral.enums.Country;
import com.servidorcentral.enums.IdType;
import com.servidorcentral.exceptions.UserAlreadyExistsException;

import java.time.LocalDate;

public interface UserController {

    void createClient(
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
    ) throws UserAlreadyExistsException;

    void createAirline(
        String username,
        String name,
        String email,
        String password,
        byte[] image,
        LocalDate registrationDate,
        String description,
        String webUrl
    ) throws UserAlreadyExistsException;

}

