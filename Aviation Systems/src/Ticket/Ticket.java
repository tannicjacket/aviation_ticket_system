package Ticket;


import Flight.Flight;

public class Ticket {

    private String ticketId;
    private Flight flight;
    private CabinClass cabinClass;
    private double price;
    private TicketStatus status; 


    public Ticket(String ticketId, Flight flight, CabinClass cabinClass, double basePrice) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.cabinClass = cabinClass;
        this.price = calculatePrice(basePrice, cabinClass);
        this.status = TicketStatus.AVAILABLE;
    }
    
    public void adjustPriceByUser(double percentage) {
        this.price += this.price * percentage;
    }

    private double calculatePrice(double basePrice, CabinClass cabinClass) {
        switch (cabinClass) {
            case ECONOMY:
                return basePrice;
            case BUSINESS:
                return basePrice * 1.5;
            case FIRST_CLASS:
                return basePrice * 2; 
            default:
                return basePrice;
        }
    }

    public enum TicketStatus {
        AVAILABLE, RESERVED
    }

    // public enum TicketType {
    //     DIRECT, CONNECT, ROUND_TRIP
    // }


    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public CabinClass getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(CabinClass cabinClass) {
        this.cabinClass = cabinClass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
    
    public void reserveTicket() {
        if (this.status == TicketStatus.AVAILABLE) {
            this.status = TicketStatus.RESERVED;
        } else {
            throw new IllegalStateException("Ticket is not available for reservation.");
        }
    }
    
}
