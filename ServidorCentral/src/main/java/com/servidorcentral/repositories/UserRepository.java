package com.servidorcentral.repositories;

import com.servidorcentral.dtos.AirlineDTO;
import com.servidorcentral.dtos.UserDTO;
import com.servidorcentral.exceptions.UserAlreadyExistsException;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class UserRepository {

    private static UserRepository instance;
    private final Map<String, User> usernameUser;
    private final Map<String, User> emailUser;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        usernameUser = new HashMap<>();
        emailUser = new HashMap<>();
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        if (usernameUser.containsKey(user.getUsername()) || emailUser.containsKey(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        usernameUser.put(user.getUsername(), user);
        emailUser.put(user.getEmail(), user);
    }

    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(usernameUser.get(username));
    }

    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(emailUser.get(email));
    }

    public Optional<User> getUser(String usernameOrEmail) {
        Optional<User> user = getUserByUsername(usernameOrEmail);
        if (user.isEmpty()) {
            user = getUserByEmail(usernameOrEmail);
        }
        return user;
    }

    public Set<UserDTO> getAllUsersDTO() {
        Set<UserDTO> usersDTO = new HashSet<>();

        for (User user: this.usernameUser.values()) {
            usersDTO.add(user.getDTO());
        }

        return usersDTO;
    }

    public Set<AirlineDTO> getAllAirlinesDTO() {
        Set<AirlineDTO> airlinesDTO = new HashSet<>();

        for (User user : this.usernameUser.values()) {
            if (user instanceof Airline airline) {
                airlinesDTO.add(airline.getDTO());
            }
        }

        return airlinesDTO;
    }

}

