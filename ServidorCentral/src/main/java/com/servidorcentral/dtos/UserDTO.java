package com.servidorcentral.dtos;

import com.servidorcentral.models.User;

import java.time.LocalDate;

public class UserDTO {

    private final String username;
    private final String email;
    private String name;
    private String password;

    private byte[] image;

    private LocalDate registrationDate;

    protected UserDTO(UserDTOBuilder<?> builder) {
        this.username = builder.username;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.image = builder.image;
        this.registrationDate = builder.registrationDate;
    }

    // Builder
    public static abstract class UserDTOBuilder<T extends UserDTOBuilder<?>> {
        private final String username;
        private final String email;
        private String name;
        private String password;
        private byte[] image;
        private LocalDate registrationDate;

        public UserDTOBuilder(String username, String email) {
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

        public UserDTO build() {
            return new UserDTO(this);
        }

    }

}

