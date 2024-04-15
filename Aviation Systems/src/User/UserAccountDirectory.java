package User;

import java.util.ArrayList;
import java.util.List;

public class UserAccountDirectory {
    private List<UserAccount> userAccounts;

    public UserAccountDirectory() {
        this.userAccounts = new ArrayList<>();
    }

    public UserAccount createUserAccount(Identifiable identifiable, String password) {
        UserAccount newUser = new UserAccount(identifiable, password);
        userAccounts.add(newUser);
        return newUser;
    }

    public UserAccount findUserByUsername(String username) {
        for (UserAccount user : userAccounts) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount user : userAccounts) {
            if (user.getUsername().equals(username) && user.verifyPassword(password)) {
                return user;
            }
        }
        return null; 
    }

    public boolean removeUserAccount(UserAccount userAccount) {
        return userAccounts.remove(userAccount);
    }

    public List<UserAccount> getAllUserAccounts() {
        return new ArrayList<>(userAccounts); 
    }
}
