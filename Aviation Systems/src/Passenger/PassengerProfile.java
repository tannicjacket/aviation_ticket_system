package Passenger;

import Person.PersonProfile;
import Order.Order;

import java.util.ArrayList;
import java.util.List;

public class PassengerProfile extends PersonProfile {
    private List<Order> orders; 

    public PassengerProfile(String id, String name, String gender, int age, String email) {
        super(id, name, gender, age, email);
        this.orders = new ArrayList<>(); 
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
