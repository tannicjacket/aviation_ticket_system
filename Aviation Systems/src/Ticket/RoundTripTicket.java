package Ticket;

public class RoundTripTicket {
    private Ticket outboundTicket;
    private Ticket returnTicket;
    private double totalPrice;
    private static final double DISCOUNT_RATE = 0.8; 

    public RoundTripTicket(Ticket outboundTicket, Ticket returnTicket) {
        this.outboundTicket = outboundTicket;
        this.returnTicket = returnTicket;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double outboundPrice = outboundTicket.getPrice();
        double returnPrice = returnTicket.getPrice() * DISCOUNT_RATE; 
        return outboundPrice + returnPrice;
    }

    public Ticket getOutboundTicket() {
        return outboundTicket;
    }

    public Ticket getReturnTicket() {
        return returnTicket;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
