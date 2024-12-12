package com.servidorcentral.dtos;

import java.math.BigDecimal;

public record CostsDTO(
        BigDecimal baseCostTouristClass,
        BigDecimal baseCostBusinessClass,
        BigDecimal costPerUnitExtraLuggage
) {}

