package com.servidorcentral.controllers;

import com.servidorcentral.dtos.ReservationDTO;
import com.servidorcentral.dtos.UserDTO;
import com.servidorcentral.exceptions.UserAlreadyExistsException;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.Client;
import com.servidorcentral.models.User;
import com.servidorcentral.repositories.UserRepository;

import java.util.Collections;
import java.util.Optional;
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

    @Override
    public Set<UserDTO> getAllUsersDTO() {
        UserRepository userRepository = UserRepository.getInstance();
        return userRepository.getAllUsersDTO();
    }

    @Override
    public Set<ReservationDTO> getUserReservationsDTO(String usernameOrEmail) {
        UserRepository userRepository = UserRepository.getInstance();
        Optional<User> optionalUser = userRepository.getUser(usernameOrEmail);

        if (optionalUser.isPresent() && optionalUser.get() instanceof Client client) {
            return client.getReservationsDTO();
        }

        return Collections.emptySet();
    }

}

