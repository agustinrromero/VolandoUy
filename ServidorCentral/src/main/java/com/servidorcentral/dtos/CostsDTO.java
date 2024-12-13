package com.servidorcentral.dtos;

import com.servidorcentral.models.Costs;

import java.math.BigDecimal;

public record CostsDTO(
        BigDecimal baseCostTouristClass,
        BigDecimal baseCostBusinessClass,
        BigDecimal costPerUnitExtraLuggage
) {

    public CostsDTO(Costs costs) {
        this(
                costs.getBaseCostTouristClass(),
                costs.getBaseCostBusinessClass(),
                costs.getCostPerUnitExtraLuggage()
        );
    }

}

