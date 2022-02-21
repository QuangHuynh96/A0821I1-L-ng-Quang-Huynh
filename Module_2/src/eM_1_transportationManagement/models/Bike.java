package transportationManagement.models;

public class Bike extends Transportation {
    private double wattage;

    public Bike() {
    }

    public Bike(String licensePlates, int year, String manufacturer, String owner, double wattage) {
        super(licensePlates, year, manufacturer, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }
}
