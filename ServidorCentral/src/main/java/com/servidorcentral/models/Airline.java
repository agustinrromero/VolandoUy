package com.servidorcentral.models;

import com.servidorcentral.dtos.AirlineDTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Airline extends User {

    private String description;
    private String webUrl;
    private Set<FlightRoute> flightRoutes;

    private Airline(AirlineBuilder builder) {
        super(builder);
        this.description = builder.description;
        this.webUrl = builder.webUrl;
        this.flightRoutes = Objects.requireNonNullElseGet(builder.flightRoutes, HashSet::new);
    }

    public Airline(AirlineDTO airlineDTO) {
        super(airlineDTO);
        this.description = airlineDTO.getDescription();
        this.webUrl = airlineDTO.getWebUrl();
        this.flightRoutes = airlineDTO.getFlightRoutes().stream()
                .map(FlightRoute::new)
                .collect(Collectors.toSet());
    }

    // Getters
    public String getDescription() {
        return this.description;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public Set<FlightRoute> getFlightRoutes() {
        return this.flightRoutes;
    }

    // Other methods
    @Override
    public AirlineDTO getDTO() {
        return new AirlineDTO(this);
    }

    // Builder
    public static class AirlineBuilder extends UserBuilder<AirlineBuilder> {
        private String description;
        private String webUrl;
        private Set<FlightRoute> flightRoutes;

        public AirlineBuilder(String username, String email) {
            super(username, email);
        }

        public AirlineBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public AirlineBuilder setWebUrl(String webUrl) {
            this.webUrl = webUrl;
            return this;
        }

        public AirlineBuilder setFlightRoutes(Set<FlightRoute> flightRoutes) {
            this.flightRoutes = flightRoutes;
            return this;
        }

        @Override
        protected AirlineBuilder self() {
            return this;
        }

        @Override
        public Airline build() {
            return new Airline(this);
        }
    }

}

