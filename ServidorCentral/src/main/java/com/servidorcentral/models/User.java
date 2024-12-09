package com.servidorcentral.models;

import java.time.LocalDate;

public class User {

    private final String username;
    private final String email;
    private String name;
    private String password;

    private byte[] image;

    private LocalDate registrationDate;

    protected User(UserBuilder<?> builder) {
        this.username = builder.username;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.image = builder.image;
        this.registrationDate = builder.registrationDate;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    // Builder
    public static abstract class UserBuilder<T extends UserBuilder<T>> {
        private final String username;
        private String name;
        private final String email;
        private String password;
        private byte[] image;
        private LocalDate registrationDate;

        public UserBuilder(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public T setName(String name) {
            this.name = name;
            return self();
        }

        public T setPassword(String password) {
            this.password = password;
            return self();
        }

        public T setImage(byte[] image) {
            this.image = image;
            return self();
        }

        public T setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return self();
        }

        protected abstract T self();

        public User build() {
            return new User(this);
        }
    }

}

