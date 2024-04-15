package Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyFlightAssignmentDirectory {
    private List<FacultyFlightAssignment> assignments;

    public FacultyFlightAssignmentDirectory() {
        this.assignments = new ArrayList<>();
    }

    public void addAssignment(FacultyFlightAssignment assignment) {
        assignments.add(assignment);
    }

    public List<FacultyFlightAssignment> getAssignments() {
        return assignments;
    }

    public List<FacultyFlightAssignment> getAssignmentsByFlightId(String flightId) {
        List<FacultyFlightAssignment> result = new ArrayList<>();
        for (FacultyFlightAssignment assignment : assignments) {
            if (assignment.getFlight().getFlightNumber().equals(flightId)) {
                result.add(assignment);
            }
        }
        return result;
    }

    public List<FacultyFlightAssignment> getAssignmentsByFacultyId(String facultyId) {
        List<FacultyFlightAssignment> result = new ArrayList<>();
        for (FacultyFlightAssignment assignment : assignments) {
            if (assignment.getFaculty().getId().equals(facultyId)) {
                result.add(assignment);
            }
        }
        return result;
    }
}
