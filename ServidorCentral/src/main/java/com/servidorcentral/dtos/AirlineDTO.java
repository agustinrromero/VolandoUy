package com.servidorcentral.dtos;

import com.servidorcentral.models.Airline;
import com.servidorcentral.models.FlightRoute;

import java.util.Set;
import java.util.stream.Collectors;

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

    public AirlineDTO(Airline airline) {
        super(airline);
        this.description = airline.getDescription();
        this.webUrl = airline.getWebUrl();
        this.flightRoutes = airline.getFlightRoutes().stream().map(FlightRoute::getDTO).collect(Collectors.toSet());
    }

	public String getDescription() {
		return this.description;
	}

	public String getWebUrl() {
		return this.webUrl;
	}

	public Set<FlightRouteDTO> getFlightRoutes() {
		return this.flightRoutes;
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

