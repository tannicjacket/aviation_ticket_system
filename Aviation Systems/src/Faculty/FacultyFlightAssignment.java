package Faculty;

import Flight.Flight;

public class FacultyFlightAssignment {
    private FacultyProfile faculty;
    private Flight flight;

    public FacultyFlightAssignment(FacultyProfile faculty, Flight flight) {
        this.faculty = faculty;
        this.flight = flight;
    }

    public FacultyProfile getFaculty() {
        return faculty;
    }

    public Flight getFlight() {
        return flight;
    }
}
