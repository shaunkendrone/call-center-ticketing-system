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
        for (int i = 0; i < ticketsList.size(); i++) {
            Ticket ticket = ticketsList.get(i);
            if (ticket.getTicketId() == updatedTicket.getTicketId()) {

                ticket.setTicketName(updatedTicket.getTicketName());
                ticket.setIssueDescription(updatedTicket.getIssueDescription());
                ticket.setCustomerName(updatedTicket.getCustomerName());
                ticket.setCustomerContact(updatedTicket.getCustomerContact());
                ticket.setStatus(updatedTicket.getStatus());
                ticket.setPriority(updatedTicket.getPriority());
                ticket.setCategory(updatedTicket.getCategory());
                ticket.setAgentName(updatedTicket.getAgentName());
            }
        }
    }

    @Override
    public void deleteTicket(int index) {
        
    }

}
