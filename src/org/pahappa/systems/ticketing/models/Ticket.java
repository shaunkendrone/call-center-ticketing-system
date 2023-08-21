package org.pahappa.systems.ticketing.models;

/**
 * A ticket refers to a unit of work or a request that is submitted
 * by a user or customer to seek assistance, report an issue, or request a service.
 * It serves as a record or a container that captures all the relevant information
 * related to the user's request or issue.
 */
public class Ticket {
    // private static int lastAssignedId = 0;
    private int ticketId;
    private String ticketName;
    private String issueDescription;
    private String customerName;
    private String customerContact;
    private int status;
    private int priority;
    private int category;
    private String agentName;
        
    public Ticket(int ticketid,String ticketName, String issueDescription,String customerName,String customerContact, int status, int priority, int category, String agentName) {
        // this.ticketId = ++lastAssignedId;
        this.ticketId = ticketid;
        this.ticketName = ticketName;
        this.issueDescription = issueDescription;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.status = status;
        this.priority = priority;
        this.category = category;
        this.agentName = agentName;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    
}
