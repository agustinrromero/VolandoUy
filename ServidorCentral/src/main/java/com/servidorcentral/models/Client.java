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

    private Client(ClientBuilder builder) {
        super(builder);
        this.lastName = builder.lastName;
        this.birthday = builder.birthday;
        this.idType = builder.idType;
        this.idNumber = builder.idNumber;
        this.country = builder.country;
    }

    // Builder
    public static class ClientBuilder extends UserBuilder<ClientBuilder> {
        private String lastName;
        private LocalDate birthday;
        private IdType idType;
        private String idNumber;
        private Country country;

        public ClientBuilder(String username, String email) {
            super(username, email);
        }

        public ClientBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ClientBuilder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public ClientBuilder setIdType(IdType idType) {
            this.idType = idType;
            return this;
        }

        public ClientBuilder setIdNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public ClientBuilder setCountry(Country country) {
            this.country = country;
            return this;
        }

        @Override
        protected ClientBuilder self() {
            return this;
        }

        @Override
        public Client build() {
            return new Client(this);
        }
    }

}

