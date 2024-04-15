package Ticket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TicketDirectory {
    private List<Ticket> tickets = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public Ticket findTicketById(String ticketId) {
        return tickets.stream()
                      .filter(ticket -> ticket.getTicketId().equals(ticketId))
                      .findFirst()
                      .orElse(null);
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }

    public List<Ticket> getTicketsByFlight(String flightNumber) {
        return tickets.stream()
                      .filter(ticket -> ticket.getFlight().getFlightNumber().equals(flightNumber))
                      .collect(Collectors.toList());
    }

    public List<Ticket> getAllTicketsSortedByDepartureTime() {
        return tickets.stream()
                .sorted(Comparator.comparing(ticket -> ticket.getFlight().getDepartureTime()))
                .collect(Collectors.toList());
    }
    
    public List<Ticket> getTicketsByFlightAndClass(String flightNumber, String seatClass) {
        return tickets.stream()
            .filter(ticket -> ticket.getFlight().getFlightNumber().equals(flightNumber) && 
                              ticket.getCabinClass().toString().equalsIgnoreCase(seatClass) &&
                              ticket.getStatus() == Ticket.TicketStatus.AVAILABLE)
            .collect(Collectors.toList());
    }


}
