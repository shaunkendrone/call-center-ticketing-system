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
        List<Ticket> myList = new ArrayList<>();
        for (Ticket ticket : ticketsList) {
            if (ticket.getStatus() == (ticketStatus.ordinal() + 1)) {
                myList.add(ticket);
            }
        }
        return myList;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {
        
    }

    @Override
    public void deleteTicket(int index) {
        
    }

}
