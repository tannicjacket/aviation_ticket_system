package User;

public class UserAccount {
    private Identifiable identifiable;
    private String username; 
    private String password;

    public UserAccount(Identifiable identifiable, String password) {
        this.identifiable = identifiable;
        this.username = identifiable.getId(); // Correctly initialized
        this.password = password;
    }

    public Identifiable getIdentifiable() {
        return identifiable;
    }

    public String getUsername() {
        return username; // Now correctly returns the initialized field
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return username;
    }
}
