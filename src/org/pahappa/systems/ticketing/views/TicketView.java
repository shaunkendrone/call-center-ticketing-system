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
            String choice = scanner.nextLine();
            if (choice.matches("\\d+")) {
                int mychoice = Integer.parseInt(choice);

                switch (mychoice) {
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
            } else {
                System.out.println("Invalid input please choose a number from the menu");
            }
        }
    }

    @Override
    public void createTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ticket id:");
        int ticketId;
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                ticketId = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid ticket id:");
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
        int status;
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                status = Integer.parseInt(input);
                if (status >= 1 && status <= 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Please choose a number from the menu above:");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid ticket status:");
            }
        }
        System.out.println("Enter ticket priority:");
        System.out.println("1. Low");
        System.out.println("2. Medium");
        System.out.println("3. High");
        int priority;
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                priority = Integer.parseInt(input);
                if (priority >= 1 && priority <= 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Please choose a number from the menu above:");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid ticket priority:");
            }
        }
        System.out.println("Enter ticket category:");
        System.out.println("1. Mobile money service");
        System.out.println("2. SIM Card and Activation");
        System.out.println("3. Voice and Internet bundles");
        System.out.println("4. Speak to one of us");
        int category;
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                category = Integer.parseInt(input);
                if (category >= 1 && category <= 4) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid ticket category:");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid ticket category:");
            }
        }
        System.out.println("Enter Agent Name:");
        String agentName = scanner.nextLine();

        Ticket ticket = new Ticket(ticketId, ticketName, issueDescription, status, priority, category, agentName);
        ticketService.createTicket(ticket);

        System.out.println("Ticket created successfully.");

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
