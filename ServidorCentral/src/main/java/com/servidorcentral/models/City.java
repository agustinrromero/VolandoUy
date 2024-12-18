package com.servidorcentral.models;

import com.servidorcentral.dtos.CityDTO;
import com.servidorcentral.enums.Country;

import java.time.LocalDate;
import java.util.Objects;

public class City {

    private final String name;
    private String description;
    private String airport;
    private String webUrl;
    private final Country country;
    private final LocalDate registrationDate;

    private City(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.airport = builder.airport;
        this.webUrl = builder.webUrl;
        this.country = builder.country;
        this.registrationDate = LocalDate.now();
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAirport() {
        return this.airport;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public Country getCountry() {
        return this.country;
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    // Other methods
    public CityDTO getDTO() {
        return new CityDTO(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return Objects.equals(name, city.name) && country == city.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    // Builder
    public static class Builder {
        private final String name;
        private String description;
        private String airport;
        private String webUrl;
        private final Country country;

        public Builder(String name, Country country) {
            this.name = name;
            this.country = country;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAirport(String airport) {
            this.airport = airport;
            return this;
        }

        public Builder setWebUrl(String webUrl) {
            this.webUrl = webUrl;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }

}
