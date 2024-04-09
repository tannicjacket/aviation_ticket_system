package Order;

import Passenger.PassengerProfile;
import Ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private PassengerProfile passenger;
    private List<Ticket> tickets;
    private double totalPrice;

    public Order(String orderId, PassengerProfile passenger) {
        this.orderId = orderId;
        this.passenger = passenger;
        this.tickets = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        totalPrice += ticket.getPrice();
    }

    public String getOrderId() {
        return orderId;
    }

    public PassengerProfile getPassenger() {
        return passenger;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
