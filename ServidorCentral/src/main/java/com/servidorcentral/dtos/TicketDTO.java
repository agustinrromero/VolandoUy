package com.servidorcentral.dtos;

import com.servidorcentral.models.Ticket;

public record TicketDTO(String firstName, String lastName, int seatNumber) {

    public TicketDTO(Ticket ticket) {
        this(ticket.getFirstName(), ticket.getLastName(), ticket.getSeatNumber());
    }

}

