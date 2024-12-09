package com.servidorcentral.models;

import com.servidorcentral.enums.ReservationType;
import com.servidorcentral.enums.SeatClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class Reservation {

    private static int idCounter = 1;

    private final int id;
    private LocalDate registrationDate;

    private Flight flight;
    private int amountTickets;
    private int amountExtraLuggage;
    private Set<Ticket> tickets;

    private ReservationType reservationType;
    private SeatClass seatClass;

    private BigDecimal totalCost;

    private Reservation(Builder builder) {
        this.id = idCounter++;
        this.registrationDate = builder.registrationDate;
        this.flight = builder.flight;
        this.amountTickets = builder.amountTickets;
        this.amountExtraLuggage = builder.amountExtraLuggage;
        this.tickets = builder.tickets;
        this.reservationType = builder.reservationType;
        this.seatClass = builder.seatClass;
        this.totalCost = builder.totalCost;
    }

    // Builder
    public static class Builder {
        private LocalDate registrationDate;

        private Flight flight;
        private int amountTickets;
        private int amountExtraLuggage;
        private Set<Ticket> tickets;

        private ReservationType reservationType;
        private SeatClass seatClass;

        private BigDecimal totalCost;

        public Builder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setFlight(Flight flight) {
            this.flight = flight;
            return this;
        }

        public Builder setAmountTickets(int amountTickets) {
            this.amountTickets = amountTickets;
            return this;
        }

        public Builder setAmountExtraLuggage(int amountExtraLuggage) {
            this.amountExtraLuggage = amountExtraLuggage;
            return this;
        }

        public Builder setTickets(Set<Ticket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public Builder setReservationType(ReservationType reservationType) {
            this.reservationType = reservationType;
            return this;
        }

        public Builder setSeatClass(SeatClass seatClass) {
            this.seatClass = seatClass;
            return this;
        }

        public Builder setTotalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }

}

