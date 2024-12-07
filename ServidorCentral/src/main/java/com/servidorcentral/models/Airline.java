package com.servidorcentral.models;

import java.time.LocalDate;

public class Airline extends User {

    private String description;
    private String webUrl;

    public Airline(String username, String name, String email, String password, byte[] image, LocalDate registrationDate, String description, String webUrl) {
        super(username, name, email, password, image, registrationDate);
        this.description = description;
        this.webUrl = webUrl;
    }

}

