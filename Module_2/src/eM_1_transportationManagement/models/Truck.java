package transportationManagement.models;

public class Truck extends Transportation {
    private double weight;

    public Truck() {
    }

    public Truck(String licensePlates, int year, String manufacturer, String owner, double weight) {
        super(licensePlates, year, manufacturer, owner);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
