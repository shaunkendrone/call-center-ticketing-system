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

    @Override
    public void createTicket() {
        System.out.println("Enter ticket id:");
        int ticketId = getValidIntegerInput(scanner);
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
