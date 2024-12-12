package com.servidorcentral.dtos;

import java.util.Set;

public class AirlineDTO extends UserDTO {

    private String description;
    private String webUrl;
    private Set<FlightRouteDTO> flightRoutes;

    private AirlineDTO(AirlineDTOBuilder builder) {
        super(builder);
        this.description = builder.description;
        this.webUrl = builder.webUrl;
        this.flightRoutes = builder.flightRoutes;
    }

    // Builder
    public static class AirlineDTOBuilder extends UserDTOBuilder<AirlineDTOBuilder> {
        private String description;
        private String webUrl;
        private Set<FlightRouteDTO> flightRoutes;

        public AirlineDTOBuilder(String name, String email) {
            super(name, email);
        }

        public AirlineDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public AirlineDTOBuilder setWebUrl(String webUrl) {
            this.webUrl = webUrl;
            return this;
        }

        public AirlineDTOBuilder setFlightRoutes(Set<FlightRouteDTO> flightRoutes) {
            this.flightRoutes = flightRoutes;
            return this;
        }

        @Override
        protected AirlineDTOBuilder self() {
            return this;
        }

        @Override
        public AirlineDTO build() {
            return new AirlineDTO(this);
        }
    }

}
