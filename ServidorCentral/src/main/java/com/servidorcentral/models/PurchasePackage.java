package com.servidorcentral.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class PurchasePackage {

    private BigDecimal price;

    private LocalDate purchaseDate;
    private LocalDate expirationDate;

    private Client client;
    private Package _package;

    private Set<Reservation> reservations;

    public PurchasePackage(
            BigDecimal price,
            LocalDate purchaseDate,
            LocalDate expirationDate,
            Client client,
            Package _package,
            Set<Reservation> reservations
    ) {
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.client = client;
        this._package = _package;
        this.reservations = reservations;
    }

}

