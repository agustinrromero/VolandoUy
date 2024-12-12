package com.servidorcentral.controllers;

import com.servidorcentral.dtos.UserDTO;
import com.servidorcentral.exceptions.UserAlreadyExistsException;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.Client;

import java.util.Set;

public interface UserController {

    void createClient(Client client) throws UserAlreadyExistsException;

    void createAirline(Airline airline) throws UserAlreadyExistsException;

    Set<UserDTO> getAllUsersDTO();

}

