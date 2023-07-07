package org.pahappa.systems.ticketing.views;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.services.impl.TicketServiceImpl;

import java.util.*;

public class TicketView implements BaseTicketView {

    private final TicketService ticketService;
    private final Scanner scanner;

    public TicketView() {
        this.ticketService = new TicketServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public int getValidIntegerInput(Scanner myScanner) {
        int input;
        while (true) {
            String myInput = myScanner.nextLine();
            if (myInput.matches("\\d+")) {
                input = Integer.parseInt(myInput);
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    public int getValidIntegerInput2(Scanner myScanner2) {
        int input;
        while (true) {
            String myInput = myScanner2.nextLine();
            if (myInput.matches("\\d+")) {
                input = Integer.parseInt(myInput);
                if (input >= 1 && input <= 3) {
                    break;
                } else {
                    System.out.println("Invalid number. Please choose a number from 1 to 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

    @Override
    public void displayMenu() {
        System.out.println("********* Call Center Ticket System *********\n\n");
        boolean running = true;
        while (running) {
            System.out.println("\tChoose an operation:");
            System.out.println("1. Create Ticket");
            System.out.println("2. Get All Tickets");
            System.out.println("3. Get Tickets of Status");
            System.out.println("4. Update Ticket");
            System.out.println("5. Delete Ticket");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter your choice:");
            int choice = getValidIntegerInput(scanner);

            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    getAllTickets();
                    break;
                case 3:
                    getTicketsOfStatus();
                    break;
                case 4:
                    updateTicket();
                    break;
                case 5:
                    deleteTicket();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }

        }
    }

    private boolean isTicketIdUsed(int ticketId) {
        List<Ticket> tickets = ticketService.getAllTickets();
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void createTicket() {
        int ticketId;
        while (true) {
            System.out.println("Enter ticket id:");
            ticketId = getValidIntegerInput(scanner);
            if (isTicketIdUsed(ticketId)) {
                System.out.println("Ticket ID is already used. Please enter a unique ID.");
            } else {
                break;
            }
        }
        System.out.println("Enter ticket name:");
        String ticketName = scanner.nextLine();
        System.out.println("Enter issue description:");
        String issueDescription = scanner.nextLine();
        System.out.println("Choose ticket status:");
        System.out.println("1. Open");
        System.out.println("2. In Progress");
        System.out.println("3. Resolved");
        int status = getValidIntegerInput2(scanner);
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer contact:");
        String customerContact = scanner.nextLine();
        System.out.println("Enter ticket priority:");
        System.out.println("1. Low");
        System.out.println("2. Medium");
        System.out.println("3. High");
        int priority = getValidIntegerInput2(scanner);
        System.out.println("Enter ticket category:");
        System.out.println("1. Mobile money service");
        System.out.println("2. Voice and Internet bundles");
        System.out.println("3. Speak to one of us");
        int category = getValidIntegerInput2(scanner);
        System.out.println("Enter Agent Name:");
        String agentName = scanner.nextLine();

        Ticket ticket = new Ticket(ticketId, ticketName, issueDescription, customerName, customerContact, status,
                priority, category, agentName);
        ticketService.createTicket(ticket);
        System.out.println("+------------------------------+");
        System.out.println("| Ticket created successfully. |");
        System.out.println("+------------------------------+");

    }

    public void getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No tickets found");
        } else {
            System.out.println("********* All Tickets *********\n\n");
            for (Ticket ticket : tickets) {

                System.out.println("Ticket ID: " + ticket.getTicketId());
                System.out.println("Ticket Name: " + ticket.getTicketName());
                System.out.println("Issue Description: " + ticket.getIssueDescription());
                System.out.println("Customer name: " + ticket.getCustomerName());
                System.out.println("Customer contact: " + ticket.getCustomerContact());
                if (ticket.getStatus() == 1) {
                    System.out.println("Ticket Status: " + TicketStatus.OPEN);
                } else if (ticket.getStatus() == 2) {
                    System.out.println("Ticket Status: " + TicketStatus.INPROGRESS);
                } else {
                    System.out.println("Ticket Status: " + TicketStatus.RESOLVED);
                }

                if (ticket.getPriority() == 1) {
                    System.out.println("Ticket Priority: Low");
                } else if (ticket.getPriority() == 2) {
                    System.out.println("Ticket Priority: Medium");
                } else {
                    System.out.println("Ticket Priority: High");
                }

                if (ticket.getCategory() == 1) {
                    System.out.println("Ticket Category: Mobile money service");
                } else if (ticket.getCategory() == 2) {
                    System.out.println("Ticket Category: Voice and Internet bundles");
                } else {
                    System.out.println("Ticket Category: Speak to one of us");
                }
                System.out.println("Agent Name: " + ticket.getAgentName());
                System.out.println("\n");
            }
        }
    }

    @Override
    public void getTicketsOfStatus() {

    }

    @Override
    public void updateTicket() {

    }

    @Override
    public void deleteTicket() {

    }
}
