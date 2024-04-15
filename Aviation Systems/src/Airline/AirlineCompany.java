package Airline;

import java.util.ArrayList;
import java.util.List;
import Faculty.FacultyDirectory;
import Faculty.FacultyFlightAssignment;
import Faculty.FacultyProfile;
import Flight.Flight;
import Flight.FlightDirectory;
import User.Identifiable;

public class AirlineCompany implements Identifiable {
    private String id;
    private String name;
    private FacultyDirectory facultyDirectory;
    private FlightDirectory flightDirectory;
    private List<FacultyFlightAssignment> assignments;


    public AirlineCompany(String id, String name) {
        this.id = id;
        this.name = name;
        this.facultyDirectory = new FacultyDirectory(); 
        this.flightDirectory = new FlightDirectory(); 
        this.assignments = new ArrayList<>();
    }

    public void addAssignment(FacultyFlightAssignment assignment) {
        assignments.add(assignment);
    }

    public void removeAssignment(FacultyFlightAssignment assignment) {
        assignments.remove(assignment);
    }

    // look up flight for faculty
    public List<Flight> getAssignmentsForFaculty(FacultyProfile faculty) {
        List<Flight> assignedFlights = new ArrayList<>();
        for (FacultyFlightAssignment assignment : assignments) {
            if (assignment.getFaculty().equals(faculty)) {
                assignedFlights.add(assignment.getFlight());
            }
        }
        return assignedFlights;
    }

    //look up faculty for flight
    public List<FacultyProfile> getFacultyForFlight(Flight flight) {
        List<FacultyProfile> assignedFaculty = new ArrayList<>();
        for (FacultyFlightAssignment assignment : assignments) {
            if (assignment.getFlight().equals(flight)) {
                assignedFaculty.add(assignment.getFaculty());
            }
        }
        return assignedFaculty;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultyDirectory;
    }

    public void addFlight(Flight flight) {
        this.flightDirectory.addFlight(flight);
    }

//    public void removeFlight(Flight flight) {
//        this.flightDirectory.removeFlight(flight);
//    }

    public FlightDirectory getFlightDirectory() {
        return flightDirectory;
    }

    @Override
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }


}
