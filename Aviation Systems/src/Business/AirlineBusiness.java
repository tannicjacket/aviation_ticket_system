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
import User.UserAccountDirectory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


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
    private UserAccountDirectory uaDirectory;
    private Set<String> availableCities = new HashSet<>();  // for storing faker cities
    

    public AirlineBusiness(String name) {
        this.name = name;
        this.airlineDirectory = new AirlineDirectory();
        this.flightDirectory = new FlightDirectory();
        this.personDirectory = new PersonDirectory();
        this.ticketDirectory = new TicketDirectory();
        this.orderDirectory = new OrderDirectory();
        this.distributorDirectory = new DistributorDirectory(); 
        this.facultyDirectory = new FacultyDirectory();
        this.passengerDirectory = new PassengerDirectory() ;
        this.ADassignmentDirectory = new ADAssignmentDirectory();
        this.ffaDirectory = new FacultyFlightAssignmentDirectory();
        this.uaDirectory = new UserAccountDirectory();
    }
    
    public Set<String> getAvailableCities() {
        return Collections.unmodifiableSet(availableCities);
    }
    
    public void addCity(String city) {
        availableCities.add(city);
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

    public UserAccountDirectory getUaDirectory() {
        return uaDirectory;
    }

    public FacultyFlightAssignmentDirectory getFfaDirectory() {
        return ffaDirectory;
    }
    
    

}
