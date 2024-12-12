package com.servidorcentral.dtos;

import com.servidorcentral.enums.SeatClass;

/**
 * Represents the association between a package and a flight route.
 * It contains the amount of times a flight route can be used in a package and the seat class for the route.
 */
public record RoutePackageDTO(FlightRouteDTO flightRoute, int amountRoutes, SeatClass seatClass) {}

