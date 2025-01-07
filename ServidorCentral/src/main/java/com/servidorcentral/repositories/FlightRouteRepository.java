package com.servidorcentral.repositories;

import com.servidorcentral.exceptions.FlightRouteAlreadyExistsException;
import com.servidorcentral.models.FlightRoute;

import java.util.HashMap;
import java.util.Map;

public class FlightRouteRepository {

    private static FlightRouteRepository instance;
    private Map<String, FlightRoute> flightRoutes;

    private FlightRouteRepository() {
        this.flightRoutes = new HashMap<>();
    }


    public static FlightRouteRepository getInstance() {
        if (instance == null) {
            instance = new FlightRouteRepository();
        }
        return instance;
    }

    public void addFlightRoute(FlightRoute flightRoute) throws FlightRouteAlreadyExistsException {
        if (this.flightRoutes.containsKey(flightRoute.getName())) {
            throw new FlightRouteAlreadyExistsException("Flight route already exists: " + flightRoute.getName());
        }

        this.flightRoutes.put(flightRoute.getName(), flightRoute);
    }

    public boolean existsFlightRoute(String name) {
        return this.flightRoutes.containsKey(name);
    }

}

