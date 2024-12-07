package com.servidorcentral.repositories;

import com.servidorcentral.exceptions.UserAlreadyExistsException;
import com.servidorcentral.models.User;

import java.util.HashMap;
import java.util.Map;

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

    public User getUserByUsername(String username) {
        return usernameUser.get(username);
    }

    public User getUserByEmail(String email) {
        return emailUser.get(email);
    }

}

