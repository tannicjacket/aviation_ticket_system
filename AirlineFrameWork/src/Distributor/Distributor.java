package Distributor;

public class Distributor {
    private String id;
    private String name;
    private double discountRate;

    public Distributor(String id, String name, double discountRate) {
        this.id = id;
        this.name = name;
        this.discountRate = discountRate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
