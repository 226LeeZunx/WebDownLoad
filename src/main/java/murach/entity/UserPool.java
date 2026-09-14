package murach.entity;

import java.util.ArrayList;
import java.util.List;

public class UserPool {
    private List<User> dataUsers; 

    public UserPool() {
        this.dataUsers = new ArrayList<>(List.of(
            new User("Tuấn", "Huỳnh", "tuanhuyn123@gmail.com"),
            new User("Admin", "System", "admin@shop.com")
        ));
    }

    public List<User> getDataUsers() {
        return dataUsers;
    }

    public User authenticate(String email) {
        return dataUsers.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public void addUser(String firstName, String lastName, String email) {
        User user = new User(firstName, lastName, email); 
        dataUsers.add(user);
    }
}