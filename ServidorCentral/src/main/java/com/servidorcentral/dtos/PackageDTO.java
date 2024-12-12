package com.servidorcentral.dtos;

import com.servidorcentral.models.RoutePackage;

import java.math.BigDecimal;
import java.util.Set;

public class PackageDTO {

    private final String name;
    private String description;
    private Set<RoutePackageDTO> routePackages;

    private int validityDays;

    private BigDecimal price;
    private BigDecimal discount;

    private PackageDTO(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.routePackages = builder.routePackages;
        this.validityDays = builder.validityDays;
        this.price = builder.price;
        this.discount = builder.discount;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Set<RoutePackageDTO> getRoutePackages() {
        return this.routePackages;
    }

    public int getValidityDays() {
        return this.validityDays;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    // Builder
    public static class Builder {
        private final String name;
        private String description;
        private Set<RoutePackageDTO> routePackages;

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

        public Builder setRoutePackages(Set<RoutePackageDTO> routePackages) {
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

        public PackageDTO build() {
            return new PackageDTO(this);
        }
    }

}

