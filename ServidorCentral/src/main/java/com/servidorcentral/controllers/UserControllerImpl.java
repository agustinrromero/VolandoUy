package com.servidorcentral.controllers;

import com.servidorcentral.dtos.UserDTO;
import com.servidorcentral.exceptions.UserAlreadyExistsException;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.Client;
import com.servidorcentral.repositories.UserRepository;

import java.util.Set;

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

    public Set<UserDTO> getAllUsersDTO() {
        UserRepository userRepository = UserRepository.getInstance();
        return userRepository.getAllUsersDTO();
    }

}

