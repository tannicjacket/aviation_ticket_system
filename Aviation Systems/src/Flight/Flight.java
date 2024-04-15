package Flight;

import java.time.LocalDateTime;

import Airline.AirlineCompany;
import Ticket.CabinClass;
import Ticket.Ticket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private Station departureStation;
    private Station arrivalStation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private AirlineCompany airlineCompany; 
    private int seatsCapacity; 
    private int reservedSeats;
    private List<Ticket> tickets;

    public Flight(String flightNumber, Station departureStation, Station arrivalStation, LocalDateTime departureTime, 
                  LocalDateTime arrivalTime, AirlineCompany airlineCompany,int seatsCapacity) {
                    
        this.flightNumber = flightNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airlineCompany = airlineCompany;
        this.seatsCapacity = seatsCapacity;
        this.reservedSeats = 0; 
        this.tickets = new ArrayList<>();
    }
    
    public List<Ticket> getTickets() {
        return tickets;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }
    
    

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public void reserveSeats(int numberOfSeats) {
        if(this.reservedSeats + numberOfSeats <= this.seatsCapacity) {
            this.reservedSeats += numberOfSeats;
        } else {
            throw new IllegalArgumentException("Not enough seats available.");
        }
    }
    
    public LocalDate getDate() {
        return departureTime.toLocalDate();
    }
    
    public double getPriceByCabinClass(CabinClass cabinClass) {
        double average = tickets.stream()
                                .filter(ticket -> ticket.getCabinClass() == cabinClass && ticket.getStatus() == Ticket.TicketStatus.AVAILABLE)
                                .mapToDouble(Ticket::getPrice)
                                .average()
                                .orElse(Double.NaN); // Returns NaN if no available tickets
        if (Double.isNaN(average)) {
            System.out.println("No tickets available for " + cabinClass);
        }
        return average;
    }
    
    public void addTicket(Ticket ticket) {
        if (this.tickets == null) {
            this.tickets = new ArrayList<>();
        }
        this.tickets.add(ticket);
    }
    
    // Method to adjust all associated ticket prices based on a percentage factor
    public void adjustTicketPricesByUser(double factor, boolean increase) {
        for (Ticket ticket : this.tickets) {
            // increase = true，factor will be used for increasing price ；if false，decrease
            double adjustment = increase ? factor : -factor;
            ticket.adjustPriceByUser(adjustment);
        }
    }

    
}

