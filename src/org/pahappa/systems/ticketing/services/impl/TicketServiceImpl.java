package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.*;

public class TicketServiceImpl implements TicketService {

    List<Ticket> ticketsList = new ArrayList<>();

    @Override
    public void createTicket(Ticket ticket) {
        ticketsList.add(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketsList;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
        return null;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {
        
    }

    @Override
    public void deleteTicket(int index) {
       
    }

}
