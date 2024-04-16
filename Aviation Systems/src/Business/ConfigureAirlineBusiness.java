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
import User.Identifiable;
import User.UserAccountDirectory;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ConfigureAirlineBusiness {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static AirlineBusiness initializeAirlineBusiness(String businessName) {
        AirlineBusiness airlineBusiness = new AirlineBusiness(businessName);
        UserAccountDirectory userAccountDirectory = airlineBusiness.getUaDirectory();

        loadAirlineCompanies(airlineBusiness, 3, userAccountDirectory);
        loadDistributors(airlineBusiness,3, userAccountDirectory); 
        assignDistributorsToCompanies(airlineBusiness); // 1 on 1 , counts of which must be equal

        loadFlights(airlineBusiness, 10); // 10 flights for each company and 150-300 seats for each flight
        loadFaculty(airlineBusiness, 50, userAccountDirectory); 
        assignFacultyToFlights(airlineBusiness);

        loadPassengers(airlineBusiness, 500, userAccountDirectory); 
        loadTickets(airlineBusiness); 
        loadOrders(airlineBusiness);
        
        // TEST: ticket and order directory
//        AirlineCompany testAirline = new AirlineCompany("AC001", "Test Airline");
//        airlineBusiness.getAirlineDirectory().addAirlineCompany(testAirline);
//
//        Station departureStation = new Station("New York");
//        Station arrivalStation = new Station("London");

//        Flight testFlight = new Flight("FL001",departureStation, arrivalStation, LocalDateTime.now(), LocalDateTime.now().plusHours(8), testAirline, 180);
//        Ticket testTicket = new Ticket("T001", testFlight, CabinClass.ECONOMY, 200.0);
//        airlineBusiness.getTicketDirectory().addTicket(testTicket);
//
//        PassengerProfile testPassenger = new PassengerProfile("P001", "John Doe", "Male", 30, "john.doe@example.com");
//        airlineBusiness.getPassengerDirectory().addPassenger(testPassenger);
//
//        Order testOrder = new Order("O001", testPassenger);
//        testOrder.addTicket(testTicket);
//        airlineBusiness.getOrderDirectory().addOrder(testOrder);
        
        return airlineBusiness;
    }

    private static void loadAirlineCompanies(AirlineBusiness business, int count,UserAccountDirectory uaDirectory) {
        List<AirlineCompany> generatedCompanies = new ArrayList<>(); // for output id
        for (int i = 0; i < count; i++) {
            String companyId = faker.bothify("AC###");
            String companyName = faker.company().name(); 
            //business.getAirlineDirectory().addAirlineCompany(new AirlineCompany(companyId,companyName));
            AirlineCompany company = new AirlineCompany(companyId, companyName);
            business.getAirlineDirectory().addAirlineCompany(company);
            uaDirectory.createUserAccount(company,"0001");
            
            generatedCompanies.add(company);
        }
        
        System.out.println("Randomly selected airline company IDs:");
        Collections.shuffle(generatedCompanies);
        generatedCompanies.stream().limit(3).forEach(company -> System.out.println(company.getId()));
    }

    public static void loadDistributors(AirlineBusiness business, int count,UserAccountDirectory uaDirectory) {
        List<Distributor> generatedDistributors = new ArrayList<>(); // for output id
        
        for (int i = 0; i < count; i++) {
            String distributorId = faker.bothify("DIS###");
            String name = faker.company().name();
            double discountRate = random.nextDouble(); 
            discountRate = 0.1 + (discountRate * 0.4); // 10% to 50% off
            
            Distributor distributor = new Distributor(distributorId, name, discountRate);
            business.getDistributorDirectory().addDistributor(distributor);
            uaDirectory.createUserAccount(distributor, "0001");
            
            generatedDistributors.add(distributor);
        }
        
        System.out.println("Randomly selected distributor IDs:");
        Collections.shuffle(generatedDistributors);
        generatedDistributors.stream().limit(3).forEach(distributor -> System.out.println(distributor.getId()));
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
        // Use fake to create a limited number of cities
        Set<String> citySet = new HashSet<>();
        while (citySet.size() < 5) {  // generate 30 cities
            String cityName = faker.address().cityName();
            citySet.add(cityName); // for output 
            business.addCity(cityName);  // for storing 
        }
        
        List<String> cities = new ArrayList<>(citySet); // convert into ArrayList for indexing

        business.getAirlineDirectory().getAirlineCompanies().forEach(airline -> {
            for (int i = 0; i < countPerAirline; i++) {
                String flightNumber = faker.bothify("FL###");
                
                // Select cities from the list
                String departureCity = cities.get(random.nextInt(cities.size()));
                String arrivalCity = cities.get(random.nextInt(cities.size()));
                // Make sure Departure != Destination
                while (arrivalCity.equals(departureCity)) {
                    arrivalCity = cities.get(random.nextInt(cities.size()));
                }
                
                
                Station departureStation = new Station(departureCity);
                Station arrivalStation = new Station(arrivalCity);
                
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
                //System.out.println("Flight " + flightNumber + " created with " + seatsCapacity + " seats.");
                
                // global directory
                business.getFlightDirectory().addFlight(flight);
                // company directory
                airline.getFlightDirectory().addFlight(flight); 
            }
        });
    }

    private static void loadFaculty(AirlineBusiness business, int countPerAirline,UserAccountDirectory uaDirectory) {
        
        List<FacultyProfile> generatedFaculty = new ArrayList<>();// for output id
        
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
                
                // global faculty directory 
                business.getFacultyDirectory().addFaculty(faculty);
                
                // company faculty directory
                airline.getFacultyDirectory().addFaculty(faculty);
                
                uaDirectory.createUserAccount(faculty, "0001");
                //uaDirectory.createUserAccount(faculty, "defaultPassword");
                
                generatedFaculty.add(faculty);
                
            }
        });
        
        System.out.println("Randomly selected faculty IDs:");
        Collections.shuffle(generatedFaculty);
        generatedFaculty.stream().limit(3).forEach(faculty -> System.out.println(faculty.getId()));
    }
    
//    private static void assignFacultyToFlights(AirlineBusiness business) {
//        List<Flight> flights = business.getFlightDirectory().getFlights();
//        List<FacultyProfile> allFaculty = business.getFacultyDirectory().getAllFaculty();
//
//        // Make sure the faculty only assigned to the same company's flights
//        Map<AirlineCompany, List<Flight>> flightsByCompany = flights.stream()
//            .collect(Collectors.groupingBy(Flight::getAirlineCompany));
//        Map<AirlineCompany, List<FacultyProfile>> facultyByCompany = allFaculty.stream()
//            .collect(Collectors.groupingBy(FacultyProfile::getAirlineCompany));
//
//        for (AirlineCompany company : business.getAirlineDirectory().getAirlineCompanies()) {
//            List<Flight> companyFlights = flightsByCompany.getOrDefault(company, new ArrayList<>());
//            List<FacultyProfile> companyFaculty = facultyByCompany.getOrDefault(company, new ArrayList<>());
//
//            // Shuffle flights to distribute assignments evenly
//            Collections.shuffle(companyFlights);
//
//            for (Flight flight : companyFlights) {
//                // Assign pilots
//                FacultyProfile pilot = findFacultyByRole(companyFaculty, "pilot");
//                if (pilot != null) {
//                    business.getffaDirectory().addAssignment(new FacultyFlightAssignment(pilot, flight));
//                    companyFaculty.remove(pilot); // Remove assigned faculty to prevent reassignment
//                }
//
//                // Assign co-pilots
//                FacultyProfile coPilot = findFacultyByRole(companyFaculty, "co-pilot");
//                if (coPilot != null) {
//                    business.getffaDirectory().addAssignment(new FacultyFlightAssignment(coPilot, flight));
//                    companyFaculty.remove(coPilot); // Remove assigned faculty to prevent reassignment
//                }
//            }
//        }
//    }

//    private static FacultyProfile findFacultyByRole(List<FacultyProfile> facultyList, String role) {
//        for (FacultyProfile faculty : facultyList) {
//            if (faculty.getRole().equalsIgnoreCase(role)) {
//                return faculty;
//            }
//        }
//        return null;
//    }
    
    private static void assignFacultyToFlights(AirlineBusiness business) {
        List<Flight> flights = business.getFlightDirectory().getFlights();
        List<FacultyProfile> allFaculty = business.getFacultyDirectory().getAllFaculty();

        // Grouping flights and faculty by airline company for company-specific assignment
        Map<AirlineCompany, List<Flight>> flightsByCompany = flights.stream()
            .collect(Collectors.groupingBy(Flight::getAirlineCompany));
        Map<AirlineCompany, List<FacultyProfile>> facultyByCompany = allFaculty.stream()
            .collect(Collectors.groupingBy(FacultyProfile::getAirlineCompany));

        for (AirlineCompany company : business.getAirlineDirectory().getAirlineCompanies()) {
            List<Flight> companyFlights = flightsByCompany.getOrDefault(company, new ArrayList<>());
            List<FacultyProfile> companyFaculty = facultyByCompany.getOrDefault(company, new ArrayList<>());

            for (Flight flight : companyFlights) {
                // Attempt to assign one pilot
                FacultyProfile pilot = findAndRemoveFacultyByRole(companyFaculty, "pilot");
                if (pilot != null) {
                    business.getffaDirectory().addAssignment(new FacultyFlightAssignment(pilot, flight));
                }

                // Attempt to assign one co-pilot
                FacultyProfile coPilot = findAndRemoveFacultyByRole(companyFaculty, "co-pilot");
                if (coPilot != null) {
                    business.getffaDirectory().addAssignment(new FacultyFlightAssignment(coPilot, flight));
                }

                // Attempt to assign at least 10 attendants
                List<FacultyProfile> attendants = findAndRemoveMultipleFacultyByRole(companyFaculty, "attendant", 10);
                for (FacultyProfile attendant : attendants) {
                    business.getffaDirectory().addAssignment(new FacultyFlightAssignment(attendant, flight));
                }
            }
        }
    }

    private static FacultyProfile findAndRemoveFacultyByRole(List<FacultyProfile> facultyList, String role) {
        for (Iterator<FacultyProfile> it = facultyList.iterator(); it.hasNext();) {
            FacultyProfile faculty = it.next();
            if (faculty.getRole().equalsIgnoreCase(role)) {
                it.remove();  // Remove faculty to prevent reassignment
                return faculty;
            }
        }
        return null;
    }

    private static List<FacultyProfile> findAndRemoveMultipleFacultyByRole(List<FacultyProfile> facultyList, String role, int count) {
        List<FacultyProfile> selectedFaculty = new ArrayList<>();
        Iterator<FacultyProfile> it = facultyList.iterator();
        while (it.hasNext() && selectedFaculty.size() < count) {
            FacultyProfile faculty = it.next();
            if (faculty.getRole().equalsIgnoreCase(role)) {
                selectedFaculty.add(faculty);
                it.remove();  // Remove faculty to prevent reassignment
            }
        }
        return selectedFaculty;
    }


    private static void loadPassengers(AirlineBusiness business, int count, UserAccountDirectory uaDirectory) {
        List<PassengerProfile> generatedPassengers = new ArrayList<>(); // for output id
        
        for (int i = 0; i < count; i++) {
            String passengerId = faker.bothify("PAS###");
            String name = faker.name().fullName();
            String gender = faker.options().option("Male", "Female", "Other");
            int age = 1 + random.nextInt(99);
            String email = faker.internet().emailAddress();
            PassengerProfile passenger = new PassengerProfile(passengerId, name, gender, age, email);
            business.getPassengerDirectory().addPassenger(passenger);
            
            uaDirectory.createUserAccount(passenger, "0001");
            
            generatedPassengers.add(passenger);
        }
        
        System.out.println("Randomly selected passenger IDs:");
        Collections.shuffle(generatedPassengers);
        generatedPassengers.stream().limit(3).forEach(passenger -> System.out.println(passenger.getId()));
    }

    private static void loadTickets(AirlineBusiness business) {
        List<Flight> flights = new ArrayList<>(business.getFlightDirectory().getFlights());
        //System.out.println("Loading tickets for flights. Total flights: " + flights.size());
        if (!flights.isEmpty()) {
            for (Flight selectedFlight : flights) {
                // Assign ticket numbers by cabin class, eco takes 70%, business takes 20%
                int totalSeats = selectedFlight.getSeatsCapacity();
                int economySeats = (int) (totalSeats * 0.7);
                int businessSeats = (int) (totalSeats * 0.2);
                int firstClassSeats = totalSeats - economySeats - businessSeats; 
    
                //System.out.println("Creating tickets for Flight: " + selectedFlight.getFlightNumber() + " with total seats: " + totalSeats);
                // create tickets to each cabin class
                createTicketsForCabinClass(business, selectedFlight, CabinClass.ECONOMY, economySeats);
                createTicketsForCabinClass(business, selectedFlight, CabinClass.BUSINESS, businessSeats);
                createTicketsForCabinClass(business, selectedFlight, CabinClass.FIRST_CLASS, firstClassSeats);
            }
        }
    }
    
    private static void createTicketsForCabinClass(AirlineBusiness business, Flight flight, CabinClass cabinClass, int seats) {
        
        
        //System.out.println("Creating tickets for Flight: " + flight.getFlightNumber() + " with actual total seats: " + flight.getSeatsCapacity());

        if (flight.getSeatsCapacity() == 0) {
            //System.out.println("Error: No seats available for Flight " + flight.getFlightNumber());
            return;  
        }
        
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
                flight.addTicket(ticket); // give ticket to flight as well
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
            int ordersCount = 1; // Ensure at least one order per passenger
            if (random.nextBoolean()) { // Randomly decide if additional orders should be created
                ordersCount += random.nextInt(3); // Add 0 to 2 additional orders
            }

            for (int i = 0; i < ordersCount; i++) {
                Order order = new Order(faker.bothify("ORD###"), passenger);
                OrderType orderType = randomOrderType();

                switch (orderType) {
                    case DIRECT:
                        if (!availableTickets.isEmpty()) {
                            Ticket ticket = availableTickets.remove(random.nextInt(availableTickets.size()));
                            ticket.reserveTicket(); // Reserve the ticket
                            order.addTicket(ticket);
                        }
                        break;
                    case CONNECT:
                        if (!availableConnectTickets.isEmpty()) {
                            ConnectTicket connectTicket = availableConnectTickets.remove(random.nextInt(availableConnectTickets.size()));
                            for (Ticket ticket : connectTicket.getTickets()) {
                                if (ticket.getStatus() == Ticket.TicketStatus.AVAILABLE) {
                                    ticket.reserveTicket(); // Reserve the ticket
                                    order.addTicket(ticket);
                                }
                            }
                        }
                        break;
                    case ROUND_TRIP:
                        if (!availableRoundTripTickets.isEmpty()) {
                            RoundTripTicket roundTripTicket = availableRoundTripTickets.remove(random.nextInt(availableRoundTripTickets.size()));
                            if (roundTripTicket.getOutboundTicket().getStatus() == Ticket.TicketStatus.AVAILABLE) {
                                roundTripTicket.getOutboundTicket().reserveTicket(); // Reserve the ticket
                                order.addTicket(roundTripTicket.getOutboundTicket());
                            }
                            if (roundTripTicket.getReturnTicket().getStatus() == Ticket.TicketStatus.AVAILABLE) {
                                roundTripTicket.getReturnTicket().reserveTicket(); // Reserve the ticket
                                order.addTicket(roundTripTicket.getReturnTicket());
                            }
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
