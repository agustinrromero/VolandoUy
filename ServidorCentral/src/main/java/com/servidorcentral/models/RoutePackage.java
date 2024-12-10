package com.servidorcentral.models;

import com.servidorcentral.enums.SeatClass;

/**
 * Represents the association between a package and a flight route.
 * It contains the amount of times a flight route can be used in a package and the seat class for the route.
 */
public class RoutePackage {

    private final FlightRoute flightRoute;
    private final int amountRoutes;
    private final SeatClass seatClass;

    private RoutePackage(FlightRoute flightRoute, int amountRoutes, SeatClass seatClass) {
        this.flightRoute = flightRoute;
        this.amountRoutes = amountRoutes;
        this.seatClass = seatClass;
    }

}

