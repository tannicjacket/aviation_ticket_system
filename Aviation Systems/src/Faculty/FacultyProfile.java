package Faculty;

import Airline.AirlineCompany;
import Person.PersonProfile;

public class FacultyProfile extends PersonProfile{

    private String role; 
    private AirlineCompany airlineCompany; 

    public FacultyProfile(String id, String name, String gender, int age, String email, String role, AirlineCompany airlineCompany) {
        super(id, name, gender, age, email);
        this.role = role;
        this.airlineCompany = airlineCompany;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
