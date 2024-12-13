package com.servidorcentral.models;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;

public class Flight {

    private String name;

    private int maxAmountTouristSeats;
    private int maxAmountBusinessSeats;

    private int availableTouristSeats;
    private int availableBusinessSeats;

    private Duration duration;
    private LocalDate departureDate;
    private LocalDate registrationDate;

    private byte[] image;

    private Map<Integer, Reservation> reservationsById;

    private Flight(Builder builder) {
        this.name = builder.name;
        this.maxAmountTouristSeats = builder.maxAmountTouristSeats;
        this.maxAmountBusinessSeats = builder.maxAmountBusinessSeats;
        this.availableTouristSeats = builder.availableTouristSeats;
        this.availableBusinessSeats = builder.availableBusinessSeats;
        this.duration = builder.duration;
        this.departureDate = builder.departureDate;
        this.registrationDate = builder.registrationDate;
        this.image = builder.image;
        this.reservationsById = builder.reservationsById;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getMaxAmountTouristSeats() {
        return this.maxAmountTouristSeats;
    }

    public int getMaxAmountBusinessSeats() {
        return this.maxAmountBusinessSeats;
    }

    public int getAvailableTouristSeats() {
        return this.availableTouristSeats;
    }

    public int getAvailableBusinessSeats() {
        return this.availableBusinessSeats;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public LocalDate getDepartureDate() {
        return this.departureDate;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public byte[] getImage() {
        return this.image;
    }

    public Map<Integer, Reservation> getReservationsById() {
        return this.reservationsById;
    }

    // Builder
    public static class Builder {
        private String name;

        private int maxAmountTouristSeats;
        private int maxAmountBusinessSeats;

        private int availableTouristSeats;
        private int availableBusinessSeats;

        private Duration duration;
        private LocalDate departureDate;
        private LocalDate registrationDate;

        private byte[] image;

        private Map<Integer, Reservation> reservationsById;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMaxAmountTouristSeats(int maxAmountTouristSeats) {
            this.maxAmountTouristSeats = maxAmountTouristSeats;
            return this;
        }

        public Builder setMaxAmountBusinessSeats(int maxAmountBusinessSeats) {
            this.maxAmountBusinessSeats = maxAmountBusinessSeats;
            return this;
        }

        public Builder setAvailableTouristSeats(int availableTouristSeats) {
            this.availableTouristSeats = availableTouristSeats;
            return this;
        }

        public Builder setAvailableBusinessSeats(int availableBusinessSeats) {
            this.availableBusinessSeats = availableBusinessSeats;
            return this;
        }

        public Builder setDuration(Duration duration) {
            this.duration = duration;
            return this;
        }

        public Builder setDepartureDate(LocalDate departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Builder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public Builder setReservationsById(Map<Integer, Reservation> reservationsById) {
            this.reservationsById = reservationsById;
            return this;
        }

        public Flight build() {
            return new Flight(this);
        }
    }

}

