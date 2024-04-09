package Distributor;

import java.util.ArrayList;
import java.util.List;

public class DistributorDirectory {
    private List<Distributor> distributors;

    public DistributorDirectory() {
        this.distributors = new ArrayList<>();
    }

    public void addDistributor(Distributor distributor) {
        distributors.add(distributor);
    }

    public void removeDistributor(Distributor distributor) {
        distributors.remove(distributor);
    }

    public Distributor findDistributorById(String id) {
        for (Distributor distributor : distributors) {
            if (distributor.getId().equals(id)) {
                return distributor;
            }
        }
        return null;
    }

    public List<Distributor> getAllDistributors() {
        return new ArrayList<>(distributors);
    }
}
