package Ticket;

import java.util.List;

public class ConnectTicket {
    private List<Ticket> tickets;
    private double totalPrice;
    private static final double DISCOUNT_RATE = 0.9; 

    public ConnectTicket(List<Ticket> tickets) {
        this.tickets = tickets;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double sum = tickets.stream().mapToDouble(Ticket::getPrice).sum();
        return sum * DISCOUNT_RATE; 
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
