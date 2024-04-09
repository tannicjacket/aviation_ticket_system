package Flight;

import java.time.LocalDateTime;

import Airline.AirlineCompany;

public class Flight {
    private String flightNumber;
    private Station departureStation;
    private Station arrivalStation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private AirlineCompany airlineCompany; 
    private int seatsCapacity; 
    private int reservedSeats;

    public Flight(String flightNumber, Station departureStation, Station arrivalStation, LocalDateTime departureTime, 
                  LocalDateTime arrivalTime, AirlineCompany airlineCompany,int seatsCapacity) {
                    
        this.flightNumber = flightNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airlineCompany = airlineCompany;
        this.reservedSeats = 0; 
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
}

