package Distributor;

import java.util.ArrayList;
import java.util.List;
import Airline.AirlineCompany;
import Flight.Flight;

public class ADAssignment {
    private AirlineCompany airlineCompany;
    private Distributor distributor;
    private List<Flight> allowedFlights; 

    public ADAssignment(AirlineCompany airlineCompany, Distributor distributor) {
        this.airlineCompany = airlineCompany;
        this.distributor = distributor;
        this.allowedFlights = new ArrayList<>();
    }

    public void addAllowedFlight(Flight flight) {
        if (!allowedFlights.contains(flight)) {
            allowedFlights.add(flight);
        }
    }

    public void removeAllowedFlight(Flight flight) {
        allowedFlights.remove(flight);
    }

    public List<Flight> getAllowedFlights() {
        return allowedFlights;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public void setAllowedFlights(List<Flight> allowedFlights) {
        this.allowedFlights = new ArrayList<>(allowedFlights);
    }


}
