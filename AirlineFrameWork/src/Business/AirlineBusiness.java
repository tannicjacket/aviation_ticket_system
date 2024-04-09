package Business;

import Person.PersonDirectory;
import Flight.FlightDirectory;
import Order.OrderDirectory;
import Passenger.PassengerDirectory;
import Ticket.TicketDirectory;
import Airline.AirlineDirectory;
import Distributor.ADAssignmentDirectory;
import Distributor.DistributorDirectory;
import Faculty.FacultyDirectory;
import Faculty.FacultyFlightAssignmentDirectory;


public class AirlineBusiness {
    private String name;
    private AirlineDirectory airlineDirectory;
    private FlightDirectory flightDirectory;
    private PersonDirectory personDirectory;
    private TicketDirectory ticketDirectory;
    private DistributorDirectory distributorDirectory;
    private FacultyDirectory facultyDirectory;
    private PassengerDirectory passengerDirectory;
    private OrderDirectory  orderDirectory;
    private ADAssignmentDirectory ADassignmentDirectory;
    private FacultyFlightAssignmentDirectory ffaDirectory;
    

    public AirlineBusiness(String name) {
        this.name = name;
        this.airlineDirectory = new AirlineDirectory();
        this.flightDirectory = new FlightDirectory();
        this.personDirectory = new PersonDirectory();
        this.ticketDirectory = new TicketDirectory();
        this.orderDirectory = new OrderDirectory();
        this.distributorDirectory = new DistributorDirectory(); 
        this. facultyDirectory = new FacultyDirectory();
        this.passengerDirectory = new PassengerDirectory() ;
    }

    public AirlineDirectory getAirlineDirectory() {
        return airlineDirectory;
    }

    public FlightDirectory getFlightDirectory() {
        return flightDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public TicketDirectory getTicketDirectory() {
        return ticketDirectory;
    }
    
    public DistributorDirectory getDistributorDirectory() {
        return distributorDirectory;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultyDirectory;
    }

    public PassengerDirectory getPassengerDirectory() {
        return passengerDirectory;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public ADAssignmentDirectory getADassignmentDirectory() {
        return ADassignmentDirectory;
    }

    public FacultyFlightAssignmentDirectory getffaDirectory() {
        return ffaDirectory;
    }

}
