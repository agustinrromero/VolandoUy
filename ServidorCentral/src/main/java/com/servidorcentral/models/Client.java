package com.servidorcentral.models;

import com.servidorcentral.dtos.ReservationDTO;
import com.servidorcentral.enums.Country;
import com.servidorcentral.enums.IdType;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class Client extends User {

    private String lastName;
    private LocalDate birthday;
    private IdType idType;
    private String idNumber;
    private Country country;

    private Set<Reservation> reservations;

    private Client(ClientBuilder builder) {
        super(builder);
        this.lastName = builder.lastName;
        this.birthday = builder.birthday;
        this.idType = builder.idType;
        this.idNumber = builder.idNumber;
        this.country = builder.country;
        this.reservations = builder.reservations;
    }

    public Set<ReservationDTO> getReservationsDTO() {
        return this.reservations.stream()
                .map(Reservation::getDTO)
                .collect(Collectors.toSet());
    }

    // Builder
    public static class ClientBuilder extends UserBuilder<ClientBuilder> {
        private String lastName;
        private LocalDate birthday;
        private IdType idType;
        private String idNumber;
        private Country country;

        private Set<Reservation> reservations;

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

        public ClientBuilder setReservations(Set<Reservation> reservations) {
            this.reservations = reservations;
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

