package com.servidorcentral.models;

import java.math.BigDecimal;
import java.util.Set;

public class Package {

    private final String name;
    private String description;
    private Set<RoutePackage> routePackages;

    private int validityDays;

    private BigDecimal price;
    private BigDecimal discount;

    private Package(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.validityDays = builder.validityDays;
        this.price = builder.price;
        this.discount = builder.discount;
        this.routePackages = builder.routePackages;
    }

    // Builder
    public static class Builder {
        private final String name;
        private String description;
        private Set<RoutePackage> routePackages;

        private int validityDays;

        private BigDecimal price;
        private BigDecimal discount;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setRoutePackages(Set<RoutePackage> routePackages) {
            this.routePackages = routePackages;
            return this;
        }

        public Builder setValidityDays(int validityDays) {
            this.validityDays = validityDays;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setDiscount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }

        public Package build() {
            return new Package(this);
        }
    }

}
