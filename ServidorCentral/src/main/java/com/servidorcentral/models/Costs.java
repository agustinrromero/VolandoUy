package com.servidorcentral.models;

import com.servidorcentral.dtos.CostsDTO;

import java.math.BigDecimal;

public class Costs {

    private BigDecimal baseCostTouristClass;
    private BigDecimal baseCostBusinessClass;
    private BigDecimal costPerUnitExtraLuggage;

    public Costs(BigDecimal baseCostTouristClass, BigDecimal baseCostBusinessClass, BigDecimal costPerUnitExtraLuggage) {
        this.baseCostTouristClass = baseCostTouristClass;
        this.baseCostBusinessClass = baseCostBusinessClass;
        this.costPerUnitExtraLuggage = costPerUnitExtraLuggage;
    }

    // Getters
    public BigDecimal getBaseCostTouristClass() {
        return baseCostTouristClass;
    }

    public BigDecimal getBaseCostBusinessClass() {
        return baseCostBusinessClass;
    }

    public BigDecimal getCostPerUnitExtraLuggage() {
        return costPerUnitExtraLuggage;
    }

    // Other methods
    public CostsDTO getDTO() {
        return new CostsDTO(this);
    }

}

