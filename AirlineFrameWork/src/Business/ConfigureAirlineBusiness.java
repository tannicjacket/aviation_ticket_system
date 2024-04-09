package Business;

import com.github.javafaker.Faker;
import Airline.*;
import Distributor.ADAssignment;
import Distributor.Distributor;
import Flight.Flight;
import Flight.Station;
import Order.Order;
import Order.OrderDirectory;
import Faculty.FacultyFlightAssignment;
import Faculty.FacultyProfile;
import Passenger.PassengerProfile;
import Ticket.Ticket;
import Ticket.CabinClass;
import Ticket.RoundTripTicket;
import Ticket.ConnectTicket;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ConfigureAirlineBusiness {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static AirlineBusiness initializeAirlineBusiness(String businessName) {
        AirlineBusiness airlineBusiness = new AirlineBusiness(businessName);

        loadAirlineCompanies(airlineBusiness, 3);
        loadDistributors(airlineBusiness,3); 
        assignDistributorsToCompanies(airlineBusiness); // 1 on 1 , counts of which must be equal

        loadFlights(airlineBusiness, 10); // 10 flights for each company and 150-300 seats for each flight
        loadFaculty(airlineBusiness, 50); 
        assignFacultyToFlights(airlineBusiness);

        loadPassengers(airlineBusiness, 100); 
        loadTickets(airlineBusiness); 
        loadOrders(airlineBusiness);

        return airlineBusiness;
    }

    private static void loadAirlineCompanies(AirlineBusiness business, int count) {
        for (int i = 0; i < count; i++) {
            String companyId = faker.bothify("AC###");
            String companyName = faker.company().name(); 
            business.getAirlineDirectory().addAirlineCompany(new AirlineCompany(companyId,companyName));
        }
    }

    public static void loadDistributors(AirlineBusiness business, int count) {
        for (int i = 0; i < count; i++) {
            String distributorId = faker.bothify("DIS###");
            String name = faker.company().name();
            double discountRate = random.nextDouble(); 
            discountRate = 0.1 + (discountRate * 0.4); // 10% to 50% off
            
            Distributor distributor = new Distributor(distributorId, name, discountRate);
            business.getDistributorDirectory().addDistributor(distributor);
        }
    }
    
    public static void assignDistributorsToCompanies(AirlineBusiness business) {
        List<AirlineCompany> airlines = new ArrayList<>(business.getAirlineDirectory().getAirlineCompanies());
        List<Distributor> distributors = new ArrayList<>(business.getDistributorDirectory().getAllDistributors());
        Collections.shuffle(distributors);  // disorder

        // distributors.size = airlines.size
        for (int i = 0; i < airlines.size(); i++) {
            AirlineCompany airline = airlines.get(i);
            Distributor distributor = distributors.get(i); 
            ADAssignment assignment = new ADAssignment(airline, distributor);
            business.getADassignmentDirectory().addAssignment(assignment);
        }
    }

    private static void loadFlights(AirlineBusiness business, int countPerAirline) {
        business.getAirlineDirectory().getAirlineCompanies().forEach(airline -> {
            for (int i = 0; i < countPerAirline; i++) {
                String flightNumber = faker.bothify("FL###");
                Station departureStation = new Station(faker.address().cityName());
                Station arrivalStation = new Station(faker.address().cityName());
                
                // randomly assign the departure date over 12 months
                int year = LocalDateTime.now().getYear();
                int month = 1 + random.nextInt(12); 
                int dayOfMonth = 1 + random.nextInt(28); 
                int hour = random.nextInt(24); 
                int minute = random.nextInt(60); 
                
                LocalDateTime departureTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
                LocalDateTime arrivalTime = departureTime.plusHours(2 + random.nextInt(11));

                // create seats for each flight around 150 - 300
                int seatsCapacity = 150 + random.nextInt(151); 
                Flight flight = new Flight(flightNumber, departureStation, arrivalStation, departureTime, arrivalTime, airline, seatsCapacity);
                business.getFlightDirectory().addFlight(flight);
            }
        });
    }

    private static void loadFaculty(AirlineBusiness business, int countPerAirline) {
        business.getAirlineDirectory().getAirlineCompanies().forEach(airline -> {
            for (int i = 0; i < countPerAirline; i++) {
                String facultyId = faker.bothify("FAC###");
                String name = faker.name().fullName();
                String gender = faker.options().option("Male", "Female", "Other");
                int age = 25 + random.nextInt(40); 
                String email = faker.internet().emailAddress();

                List<String> roles = Arrays.asList("attendant", "pilot", "co-pilot");
                String role = roles.get(random.nextInt(roles.size()));
    
                FacultyProfile faculty = new FacultyProfile(facultyId, name, gender, age, email, role, airline);
    
                business.getFacultyDirectory().addFaculty(faculty);
            }
        });
    }

    private static void assignFacultyToFlights(AirlineBusiness business) {
        List<Flight> flights = business.getFlightDirectory().getFlights();
        List<FacultyProfile> allFaculty = business.getFacultyDirectory().getAllFaculty();

        for (Flight flight : flights) {
            // filter faculty from the same company with the flight
            List<FacultyProfile> companyFaculty = allFaculty.stream()
                    .filter(faculty -> faculty.getAirlineCompany().equals(flight.getAirlineCompany()))
                    .collect(Collectors.toList());

            // assign 1 pilot and 1 co-pilot
            FacultyProfile pilot = findFacultyByRole(companyFaculty, "pilot");
            if (pilot != null) {
                companyFaculty.remove(pilot); // remove assigned pilot from the list to prevent conflict
                business.getffaDirectory().addAssignment(new FacultyFlightAssignment(pilot, flight));
            }

            FacultyProfile coPilot = findFacultyByRole(companyFaculty, "co-pilot");
            if (coPilot != null) {
                business.getffaDirectory().addAssignment(new FacultyFlightAssignment(coPilot, flight));
            }
        }
    }

    private static FacultyProfile findFacultyByRole(List<FacultyProfile> facultyList, String role) {
        for (FacultyProfile faculty : facultyList) {
            if (faculty.getRole().equalsIgnoreCase(role)) {
                return faculty;
            }
        }
        return null;
    }

    private static void loadPassengers(AirlineBusiness business, int count) {
        for (int i = 0; i < count; i++) {
            String passengerId = faker.bothify("PAS###");
            String name = faker.name().fullName();
            String gender = faker.options().option("Male", "Female", "Other");
            int age = 1 + random.nextInt(99);
            String email = faker.internet().emailAddress();
            PassengerProfile passenger = new PassengerProfile(passengerId, name, gender, age, email);
            business.getPassengerDirectory().addPassenger(passenger);
        }
    }

    private static void loadTickets(AirlineBusiness business) {
        List<Flight> flights = new ArrayList<>(business.getFlightDirectory().getFlights());
        if (!flights.isEmpty()) {
            for (Flight selectedFlight : flights) {
                // Assign ticket numbers by cabin class, eco takes 70%, business takes 20%
                int totalSeats = selectedFlight.getSeatsCapacity();
                int economySeats = (int) (totalSeats * 0.7);
                int businessSeats = (int) (totalSeats * 0.2);
                int firstClassSeats = totalSeats - economySeats - businessSeats; 
    
                // create tickets to each cabin class
                createTicketsForCabinClass(business, selectedFlight, CabinClass.ECONOMY, economySeats);
                createTicketsForCabinClass(business, selectedFlight, CabinClass.BUSINESS, businessSeats);
                createTicketsForCabinClass(business, selectedFlight, CabinClass.FIRST_CLASS, firstClassSeats);
            }
        }
    }
    
    private static void createTicketsForCabinClass(AirlineBusiness business, Flight flight, CabinClass cabinClass, int seats) {
        // get company ID
        String airlineId = flight.getAirlineCompany().getId();
        // find distributor ID
        List<ADAssignment> assignments = business.getADassignmentDirectory().getAssignmentsByAirlineId(airlineId);
        
        double discountRate = 0; 
        if (!assignments.isEmpty()) {
            // 1 on 1
            Distributor distributor = assignments.get(0).getDistributor();
            discountRate = distributor.getDiscountRate();
        }
    
        for (int i = 0; i < seats; i++) {
            if (flight.getReservedSeats() < flight.getSeatsCapacity()) {
                String ticketId = faker.bothify("TIC###");
                double basePrice = 50 + random.nextDouble() * 450;
    
                double finalPrice = basePrice * (1 - discountRate);
                
                Ticket ticket = new Ticket(ticketId, flight, cabinClass, finalPrice);
                business.getTicketDirectory().addTicket(ticket);
                
                flight.setReservedSeats(flight.getReservedSeats() + 1);
            }
        }
    }

    private static List<ConnectTicket> combineConnectTickets(List<Ticket> availableTickets) {
        List<ConnectTicket> connectTickets = new ArrayList<>();
        // availableTickets are ordered by departing time.
    
        for (int i = 0; i < availableTickets.size(); i++) {
            for (int j = i + 1; j < availableTickets.size(); j++) {
                Ticket firstTicket = availableTickets.get(i);
                Ticket secondTicket = availableTickets.get(j);
    
                // first departure = second destination && seccond departure time is late than first arrival time
                if (firstTicket.getFlight().getArrivalStation().equals(secondTicket.getFlight().getDepartureStation()) &&
                    firstTicket.getFlight().getArrivalTime().isBefore(secondTicket.getFlight().getDepartureTime())) {
    
                    List<Ticket> ticketsForConnect = Arrays.asList(firstTicket, secondTicket);
    
                    ConnectTicket connectTicket = new ConnectTicket(ticketsForConnect);
                    connectTickets.add(connectTicket);
                }
            }
        }
    
        return connectTickets;
    }

    private static List<RoundTripTicket> combineRoundTripTickets(List<Ticket> availableTickets) {
        List<RoundTripTicket> roundTripTickets = new ArrayList<>();
    
        for (int i = 0; i < availableTickets.size(); i++) {
            for (int j = 0; j < availableTickets.size(); j++) {
                if (i == j) continue; // Skip comparing the same ticket
                
                Ticket outboundTicket = availableTickets.get(i);
                Ticket returnTicket = availableTickets.get(j);
    
                // outbound departure = return destination && outbound destination = return departure && return departure time late than outbound arrival time
                if (outboundTicket.getFlight().getDepartureStation().equals(returnTicket.getFlight().getArrivalStation()) &&
                    outboundTicket.getFlight().getArrivalStation().equals(returnTicket.getFlight().getDepartureStation()) &&
                    outboundTicket.getFlight().getArrivalTime().isBefore(returnTicket.getFlight().getDepartureTime())) {
                    
                    RoundTripTicket roundTripTicket = new RoundTripTicket(outboundTicket, returnTicket);
                    roundTripTickets.add(roundTripTicket);
                }
            }
        }
    
        return roundTripTickets;
    }
    
    private static void loadOrders(AirlineBusiness business) {
        List<PassengerProfile> passengers = business.getPassengerDirectory().getAllPassengers();
        List<Ticket> availableTickets = new ArrayList<>(business.getTicketDirectory().getAllTicketsSortedByDepartureTime());
    
        List<ConnectTicket> availableConnectTickets = combineConnectTickets(availableTickets);
        List<RoundTripTicket> availableRoundTripTickets = combineRoundTripTickets(availableTickets);
    
        OrderDirectory orderDirectory = business.getOrderDirectory();
    
        for (PassengerProfile passenger : passengers) {
            int ordersCount = 1 + random.nextInt(3); // Random Order Number
    
            for (int i = 0; i < ordersCount; i++) {
                // Random Order Type
                OrderType orderType = randomOrderType();
    
                Order order = new Order(faker.bothify("ORD###"), passenger);
    
                switch (orderType) {
                    case DIRECT:
                        if (!availableTickets.isEmpty()) {
                            Ticket ticket = availableTickets.remove(random.nextInt(availableTickets.size()));
                            order.addTicket(ticket);
                        }
                        break;
                    case CONNECT:
                        if (!availableConnectTickets.isEmpty()) {
                            ConnectTicket connectTicket = availableConnectTickets.remove(random.nextInt(availableConnectTickets.size()));                          
                            connectTicket.getTickets().forEach(order::addTicket);// add every ticket into order
                        }
                        break;
                    case ROUND_TRIP:
                        if (!availableRoundTripTickets.isEmpty()) {
                            RoundTripTicket roundTripTicket = availableRoundTripTickets.remove(random.nextInt(availableRoundTripTickets.size()));
                            order.addTicket(roundTripTicket.getOutboundTicket());
                            order.addTicket(roundTripTicket.getReturnTicket());
                        }
                        break;
                }
    
                if (!order.getTickets().isEmpty()) {
                    orderDirectory.addOrder(order);
                    passenger.addOrder(order); // Connect orders with passenger
                }
            }
        }
    }
    
    private enum OrderType {
        DIRECT, CONNECT, ROUND_TRIP;
    }
    
    // helper function for Random Order
    private static OrderType randomOrderType() {
        OrderType[] values = OrderType.values();
        return values[random.nextInt(values.length)];
    }
    
    
    
}
