package com.servidorcentral.models;

import com.servidorcentral.enums.Country;
import com.servidorcentral.enums.IdType;

import java.time.LocalDate;

public class Client extends User {

    private String lastName;
    private LocalDate birthday;
    private IdType idType;
    private String idNumber;
    private Country country;

    public Client(String username, String name, String email, String password, byte[] image, LocalDate registrationDate, String lastName, LocalDate birthday, IdType idType, String idNumber, Country country) {
        super(username, name, email, password, image, registrationDate);
        this.lastName = lastName;
        this.birthday = birthday;
        this.idType = idType;
        this.idNumber = idNumber;
        this.country = country;
    }

}

