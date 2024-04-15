package Distributor;

import Distributor.ADAssignmentDirectory;
import Order.Order;
import Order.OrderDirectory;
import Ticket.Ticket;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SalesRevenueReport {
    private OrderDirectory orderDirectory;
    private ADAssignmentDirectory adAssignmentDirectory;

    public SalesRevenueReport(OrderDirectory orderDirectory, ADAssignmentDirectory adAssignmentDirectory) {
        this.orderDirectory = orderDirectory;
        this.adAssignmentDirectory = adAssignmentDirectory;
    }

    // input Distributor ID and Month => revenue
    public double calculateSalesRevenueByDistributorAndMonth(String distributorId, YearMonth month) {
        return calculateSalesRevenue(distributorId, order -> order.getTickets().stream()
            .anyMatch(ticket -> YearMonth.from(ticket.getFlight().getDepartureTime()).equals(month)));
    }

    // input Distributor ID and cabinclass => revenue
    public double calculateSalesRevenueByDistributorAndCabinClass(String distributorId, String cabinClass) {
        return calculateSalesRevenue(distributorId, order -> order.getTickets().stream()
            .anyMatch(ticket -> ticket.getCabinClass().toString().equalsIgnoreCase(cabinClass)));
    }

    // input Distributor ID and ageGroup => revenue
    public double calculateSalesRevenueByDistributorAndAgeRange(String distributorId, int ageFrom, int ageTo) {
        return calculateSalesRevenue(distributorId, order -> order.getPassenger().getAge() >= ageFrom && order.getPassenger().getAge() <= ageTo);
    }

    // helper: input distributor ID and filter conditions
    private double calculateSalesRevenue(String distributorId, Predicate<Order> additionalFilter) {
        List<Order> filteredOrders = this.orderDirectory.getAllOrders().stream()
            .filter(order ->
                adAssignmentDirectory.getAssignmentsByAirlineId(order.getTickets().get(0).getFlight().getAirlineCompany().getId()).stream()
                .anyMatch(assignment -> assignment.getDistributor().getId().equals(distributorId)))
            .filter(additionalFilter)
            .collect(Collectors.toList());

        return filteredOrders.stream()
            .flatMap(order -> order.getTickets().stream())
            .mapToDouble(Ticket::getPrice)
            .sum();
    }
}
