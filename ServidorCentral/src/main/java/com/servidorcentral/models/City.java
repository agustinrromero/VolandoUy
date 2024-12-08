package com.servidorcentral.models;

import com.servidorcentral.enums.Country;

import java.time.LocalDate;

public class City {

    private String name;
    private String description;
    private String airport;
    private String webUrl;
    private Country country;
    private LocalDate registrationDate;

    public City(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.airport = builder.airport;
        this.webUrl = builder.webUrl;
        this.country = builder.country;
        this.registrationDate = builder.registrationDate;
    }

    // Builder
    public static class Builder {
        private String name;
        private String description;
        private String airport;
        private String webUrl;
        private Country country;
        private LocalDate registrationDate;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder airport(String airport) {
            this.airport = airport;
            return this;
        }

        public Builder webUrl(String webUrl) {
            this.webUrl = webUrl;
            return this;
        }

        public Builder country(Country country) {
            this.country = country;
            return this;
        }

        public Builder registrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }

}
