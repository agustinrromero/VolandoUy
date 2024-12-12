package com.servidorcentral.models;

import com.servidorcentral.dtos.TicketDTO;

public class Ticket {

    private String firstName;
    private String lastName;
    private int seatNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public TicketDTO getDTO() {
        return new TicketDTO(this);
    }

}

