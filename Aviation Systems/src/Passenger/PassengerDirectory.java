package Passenger;

import java.util.ArrayList;
import java.util.List;
// import Passenger.*;
// import Person.*;

public class PassengerDirectory {
    private List<PassengerProfile> passengerList = new ArrayList<>();

    public void addPassenger(PassengerProfile passenger) {
        passengerList.add(passenger);
    }

    public void removePassenger(PassengerProfile passenger) {
        passengerList.remove(passenger);
    }

    public PassengerProfile findPassengerById(String id) {
        for (PassengerProfile passenger : passengerList) {
            if (passenger.getId().equals(id)) {
                return passenger;
            }
        }
        return null;
    }

    public List<PassengerProfile> getAllPassengers() {
        return new ArrayList<>(passengerList);
    }
}





// package Passenger;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// // import Passenger.*;
// // import Person.*;

// public class PassengerDirectory {
//     private Map<String, PassengerProfile> passengerMap = new HashMap<>();

//     public void addPassenger(PassengerProfile passenger) {
//         passengerMap.put(passenger.getId(), passenger);
//     }

//     public void removePassengerById(String id) {
//         passengerMap.remove(id);
//     }

//     public PassengerProfile findPassengerById(String id) {
//         return passengerMap.get(id);
//     }

//     public List<PassengerProfile> getAllPassengers() {
//         return new ArrayList<>(passengerMap.values());
//     }

// }
