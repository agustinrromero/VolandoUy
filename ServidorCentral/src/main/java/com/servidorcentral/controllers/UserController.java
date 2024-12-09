package com.servidorcentral.controllers;

import com.servidorcentral.enums.Country;
import com.servidorcentral.enums.IdType;
import com.servidorcentral.exceptions.UserAlreadyExistsException;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.Client;

import java.time.LocalDate;

public interface UserController {

    void createClient(Client client) throws UserAlreadyExistsException;

    void createAirline(Airline airline) throws UserAlreadyExistsException;

}

