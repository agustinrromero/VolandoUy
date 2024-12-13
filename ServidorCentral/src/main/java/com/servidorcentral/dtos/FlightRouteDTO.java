package com.servidorcentral.dtos;

import com.servidorcentral.enums.FlightRouteStatus;
import com.servidorcentral.models.Category;
import com.servidorcentral.models.Flight;
import com.servidorcentral.models.FlightRoute;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightRouteDTO {

    private final String name;

    private String description;
    private String shortDescription;
    private CostsDTO costs;
    private LocalDate registrationDate;
    private LocalTime departureTime;

    private Set<CategoryDTO> categories;
    private CityDTO origin;
    private CityDTO destination;
    Set<FlightDTO> flights;
    private AirlineDTO airline;

    private FlightRouteStatus status;
    private LocalDate completionDate;

    private byte[] image;
    private String videoUrl;

    private int visits;

    private FlightRouteDTO(Builder builder) {
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

    public FlightRouteDTO(FlightRoute flightRoute) {
        this.name = flightRoute.getName();
        this.description = flightRoute.getDescription();
        this.shortDescription = flightRoute.getShortDescription();
        this.costs = flightRoute.getCosts().getDTO();
        this.registrationDate = flightRoute.getRegistrationDate();
        this.departureTime = flightRoute.getDepartureTime();
        this.categories = flightRoute.getCategories().stream().map(Category::getDTO).collect(Collectors.toSet());
        this.origin = flightRoute.getOrigin().getDTO();
        this.destination = flightRoute.getDestination().getDTO();
        this.flights = flightRoute.getFlights().stream().map(Flight::getDTO).collect(Collectors.toSet());
        this.airline = flightRoute.getAirline().getDTO();
        this.status = flightRoute.getStatus();
        this.completionDate = flightRoute.getCompletionDate();
        this.image = flightRoute.getImage();
        this.videoUrl = flightRoute.getVideoUrl();
        this.visits = flightRoute.getVisits();
    }

    // Builder
    public static class Builder {
        private final String name;

        private String description;
        private String shortDescription;
        private CostsDTO costs;
        private LocalDate registrationDate;
        private LocalTime departureTime;

        private Set<CategoryDTO> categories;
        private CityDTO origin;
        private CityDTO destination;
        Set<FlightDTO> flights;
        private AirlineDTO airline;

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

        public Builder setCosts(CostsDTO costs) {
            this.costs = costs;
            return this;
        }

        public Builder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setDepartureTime(LocalTime departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public Builder setCategories(Set<CategoryDTO> categories) {
            this.categories = categories;
            return this;
        }

        public Builder setOrigin(CityDTO origin) {
            this.origin = origin;
            return this;
        }

        public Builder setDestination(CityDTO destination) {
            this.destination = destination;
            return this;
        }

        public Builder setFlights(Set<FlightDTO> flights) {
            this.flights = flights;
            return this;
        }

        public Builder setAirline(AirlineDTO airline) {
            this.airline = airline;
            return this;
        }

        public Builder setStatus(FlightRouteStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCompletionDate(LocalDate completionDate) {
            this.completionDate = completionDate;
            return this;
        }

        public Builder setImage(byte[] image) {
            this.image = image;
            return this;
        }

        public Builder setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder setVisits(int visits) {
            this.visits = visits;
            return this;
        }

        public FlightRouteDTO build() {
            return new FlightRouteDTO(this);
        }
    }

}

