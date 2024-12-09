package com.servidorcentral.models;

import java.time.LocalDate;
import java.util.Set;

public class Airline extends User {

    private String description;
    private String webUrl;
    private Set<FlightRoute> flightRoutes;

    private Airline(AirlineBuilder builder) {
        super(builder);
        this.description = builder.description;
        this.webUrl = builder.webUrl;
        this.flightRoutes = builder.flightRoutes;
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

