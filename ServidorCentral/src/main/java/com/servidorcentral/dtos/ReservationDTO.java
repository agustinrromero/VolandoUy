package com.servidorcentral.dtos;

import com.servidorcentral.enums.ReservationType;
import com.servidorcentral.enums.SeatClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class ReservationDTO {

    private final int id;
    private LocalDate registrationDate;

    private FlightDTO flight;
    private int amountTickets;
    private int amountExtraLuggage;
    private Set<TicketDTO> tickets;

    private ReservationType reservationType;
    private SeatClass seatClass;

    private BigDecimal totalCost;

    private ReservationDTO(Builder builder) {
        this.id = builder.id;
        this.registrationDate = builder.registrationDate;
        this.flight = builder.flight;
        this.amountTickets = builder.amountTickets;
        this.amountExtraLuggage = builder.amountExtraLuggage;
        this.tickets = builder.tickets;
        this.reservationType = builder.reservationType;
        this.seatClass = builder.seatClass;
        this.totalCost = builder.totalCost;
    }

    public static class Builder {
        private final int id;
        private LocalDate registrationDate;

        private FlightDTO flight;
        private int amountTickets;
        private int amountExtraLuggage;
        private Set<TicketDTO> tickets;

        private ReservationType reservationType;
        private SeatClass seatClass;

        private BigDecimal totalCost;

        public Builder(int id) {
            this.id = id;
        }

        public Builder setRegistrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder setFlight(FlightDTO flight) {
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

        public Builder setTickets(Set<TicketDTO> tickets) {
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

        public ReservationDTO build() {
            return new ReservationDTO(this);
        }
    }

}

