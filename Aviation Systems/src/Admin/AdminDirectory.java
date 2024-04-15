package Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminDirectory {
    private List<Administrator> administrators;

    public AdminDirectory(){
        this.administrators = new ArrayList<>();
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
    }

    public void removeAdministrator(Administrator administrator) {
        administrators.remove(administrator);
    }

    public Administrator findAdministratorById(String id) {
        for (Administrator admin : administrators) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        return null; 
    }
}

