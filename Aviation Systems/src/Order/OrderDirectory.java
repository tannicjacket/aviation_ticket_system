package Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDirectory {
    private List<Order> orders;

    public OrderDirectory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public Order findOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }


    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
