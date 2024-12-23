package com.servidorcentral.models;

import com.servidorcentral.dtos.FlightRouteDTO;
import com.servidorcentral.enums.FlightRouteStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class FlightRoute {

    private final String name;

    private String description;
    private String shortDescription;
    private Costs costs;
    private LocalDate registrationDate;
    private LocalTime departureTime;

    private Set<Category> categories;
    private City origin;
    private City destination;
    Set<Flight> flights;
    private Airline airline;

    private FlightRouteStatus status;
    private LocalDate completionDate;

    private byte[] image;
    private String videoUrl;

    private int visits;

    private FlightRoute(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.shortDescription = builder.shortDescription;
        this.costs = builder.costs;
        this.registrationDate = builder.registrationDate;
        this.departureTime = builder.departureTime;
        this.categories = builder.categories;
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.flights = builder.flights;
        this.airline = builder.airline;
        this.status = builder.status;
        this.completionDate = builder.completionDate;
        this.image = builder.image;
        this.videoUrl = builder.videoUrl;
        this.visits = builder.visits;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public Costs getCosts() {
        return this.costs;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public City getOrigin() {
        return this.origin;
    }

    public City getDestination() {
        return this.destination;
    }

    public Set<Flight> getFlights() {
        return this.flights;
    }

    public Airline getAirline() {
        return this.airline;
    }

    public FlightRouteStatus getStatus() {
        return this.status;
    }

    public LocalDate getCompletionDate() {
        return this.completionDate;
    }

    public byte[] getImage() {
        return this.image;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVisits() {
        return this.visits;
    }

    // Other methods
    public FlightRouteDTO getDTO() {
        return new FlightRouteDTO(this);
    }

    // Builder
    public static class Builder {
        private final String name;

        private String description;
        private String shortDescription;
        private Costs costs;
        private LocalDate registrationDate;
        private LocalTime departureTime;

        private Set<Category> categories;
        private City origin;
        private City destination;
        Set<Flight> flights;
        private Airline airline;

        private FlightRouteStatus status;
        private LocalDate completionDate;

        private byte[] image;
        private String videoUrl;

        private int visits;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public Builder setCosts(Costs costs) {
            this.costs = costs;
            return this;
        }

        public void setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
        }

        public void setDepartureTime(LocalTime departureTime) {
            this.departureTime = departureTime;
        }

        public void setCategories(Set<Category> categories) {
            this.categories = categories;
        }

        public void setOrigin(City origin) {
            this.origin = origin;
        }

        public void setDestination(City destination) {
            this.destination = destination;
        }

        public void setFlights(Set<Flight> flights) {
            this.flights = flights;
        }

        public void setAirline(Airline airline) {
            this.airline = airline;
        }

        public void setStatus(FlightRouteStatus status) {
            this.status = status;
        }

        public void setCompletionDate(LocalDate completionDate) {
            this.completionDate = completionDate;
        }

        public void setImage(byte[] image) {
            this.image = image;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public void setVisits(int visits) {
            this.visits = visits;
        }

        public FlightRoute build() {
            return new FlightRoute(this);
        }
    }

}

