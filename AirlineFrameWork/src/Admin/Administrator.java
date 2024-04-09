package Admin;

import java.util.List;

import Airline.AirlineCompany;
import Distributor.Distributor;

public class Administrator {
    private String id;
    private String name;


    public Administrator(String id,String name){
        this.id = id;
        this.name = name;
    }

    public void addAirlineCompany(List<AirlineCompany> airlineCompanies, AirlineCompany airlineCompany) {
        airlineCompanies.add(airlineCompany);
    }

    public void removeAirlineCompany(List<AirlineCompany> airlineCompanies, AirlineCompany airlineCompany) {
        airlineCompanies.remove(airlineCompany);
    }

    public void addDistributor(List<Distributor> distributors, Distributor distributor) {
        distributors.add(distributor);
    }

    public void removeDistributor(List<Distributor> distributors, Distributor distributor) {
        distributors.remove(distributor);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
