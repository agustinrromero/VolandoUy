package com.servidorcentral.models;

import java.time.LocalDate;

public class User {

    private final String username;
    private String name;
    private final String email;
    private String password;
    private byte[] image;
    private LocalDate registrationDate;

    public User(String username, String name, String email, String password, byte[] image, LocalDate registrationDate) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;
        this.registrationDate = registrationDate;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

}

