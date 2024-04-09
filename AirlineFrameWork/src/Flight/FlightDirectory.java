package Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDirectory {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

}
