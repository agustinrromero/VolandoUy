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
    public void createClient(Client client) throws UserAlreadyExistsException {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUser(client);
    }

    @Override
    public void createAirline(Airline airline) throws UserAlreadyExistsException {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUser(airline);
    }

}

