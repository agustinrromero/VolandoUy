package com.servidorcentral.dtos;

import com.servidorcentral.enums.Country;
import com.servidorcentral.models.City;

import java.time.LocalDate;

public class CityDTO {

    private final String name;
    private String description;
    private String airport;
    private String webUrl;
    private final Country country;
    private LocalDate registrationDate;

    private CityDTO(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.airport = builder.airport;
        this.webUrl = builder.webUrl;
        this.country = builder.country;
        this.registrationDate = builder.registrationDate;
    }

    public CityDTO(City city) {
        this.name = city.getName();
        this.description = city.getDescription();
        this.airport = city.getAirport();
        this.webUrl = city.getWebUrl();
        this.country = city.getCountry();
        this.registrationDate = city.getRegistrationDate();
    }

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

    // Builder
    public static class Builder {
        private final String name;
        private String description;
        private String airport;
        private String webUrl;
        private final Country country;
        private LocalDate registrationDate;

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

        public Builder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public CityDTO build() {
            return new CityDTO(this);
        }
    }

}

