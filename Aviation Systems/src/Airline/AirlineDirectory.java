package Airline;

import java.util.ArrayList;
import java.util.List;

public class AirlineDirectory {
    private List<AirlineCompany> airlineCompanies;


    public AirlineDirectory() {
        this.airlineCompanies = new ArrayList<>();
    }

    public void addAirlineCompany(AirlineCompany airlineCompany) {
        airlineCompanies.add(airlineCompany);
    }

    public void removeAirlineCompany(AirlineCompany airlineCompany) {
        airlineCompanies.remove(airlineCompany);
    }

    public AirlineCompany findAirlineCompanyById(String id) {
        for (AirlineCompany company : airlineCompanies) {
            if (company.getId().equals(id)) {
                return company;
            }
        }
        return null;
    }
    
    public AirlineCompany findAirlineByName(String name) {
        for (AirlineCompany company : airlineCompanies) {
            if (company.getName().equalsIgnoreCase(name)) {
                return company;
            }
        }
        return null;
    }

    public List<AirlineCompany> getAirlineCompanies() {
        return airlineCompanies;
    }
}
