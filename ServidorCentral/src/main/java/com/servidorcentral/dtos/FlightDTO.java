package com.servidorcentral.dtos;

import com.servidorcentral.models.Flight;

import java.time.Duration;
import java.time.LocalDate;

public class FlightDTO {

    private final String name;

    private int maxAmountTouristSeats;
    private int maxAmountBusinessSeats;

    private int availableTouristSeats;
    private int availableBusinessSeats;

    private Duration duration;
    private LocalDate departureDate;
    private LocalDate registrationDate;

    private byte[] image;

    private FlightDTO(Builder builder) {
        this.name = builder.name;
        this.maxAmountTouristSeats = builder.maxAmountTouristSeats;
        this.maxAmountBusinessSeats = builder.maxAmountBusinessSeats;
        this.availableTouristSeats = builder.availableTouristSeats;
        this.availableBusinessSeats = builder.availableBusinessSeats;
        this.duration = builder.duration;
        this.departureDate = builder.departureDate;
        this.registrationDate = builder.registrationDate;
        this.image = builder.image;
    }

    public FlightDTO(Flight flight) {
        this.name = flight.getName();
        this.maxAmountTouristSeats = flight.getMaxAmountTouristSeats();
        this.maxAmountBusinessSeats = flight.getMaxAmountBusinessSeats();
        this.availableTouristSeats = flight.getAvailableTouristSeats();
        this.availableBusinessSeats = flight.getAvailableBusinessSeats();
        this.duration = flight.getDuration();
        this.departureDate = flight.getDepartureDate();
        this.registrationDate = flight.getRegistrationDate();
        this.image = flight.getImage();
    }

    // Builder
    public static class Builder {
        private final String name;
        private int maxAmountTouristSeats;
        private int maxAmountBusinessSeats;
        private int availableTouristSeats;
        private int availableBusinessSeats;
        private Duration duration;
        private LocalDate departureDate;
        private LocalDate registrationDate;
        private byte[] image;

        public Builder(String name) {
            this.name = name;
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

        public FlightDTO build() {
            return new FlightDTO(this);
        }
    }

}

