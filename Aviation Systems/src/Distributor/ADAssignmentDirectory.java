package Distributor;

import java.util.ArrayList;
import java.util.List;

public class ADAssignmentDirectory {
    private List<ADAssignment> assignments;

    public ADAssignmentDirectory() {
        this.assignments = new ArrayList<>();
    }

    public void addAssignment(ADAssignment assignment) {
        assignments.add(assignment);
    }

    public List<ADAssignment> getAssignments() {
        return assignments;
    }

    public List<ADAssignment> getAssignmentsByAirlineId(String airlineId) {
        List<ADAssignment> result = new ArrayList<>();
        for (ADAssignment assignment : assignments) {
            if (assignment.getAirlineCompany().getId().equals(airlineId)) {
                result.add(assignment);
            }
        }
        return result;
    }

    public List<ADAssignment> getAssignmentsByDistributorId(String distributorId) {
        List<ADAssignment> result = new ArrayList<>();
        for (ADAssignment assignment : assignments) {
            if (assignment.getDistributor().getId().equals(distributorId)) {
                result.add(assignment);
            }
        }
        return result;
    }
}
