package transportationManagement.models;

public abstract class Transportation {
    private String licensePlates;
    private int year;
    private String manufacturer;
    private String owner;

    public Transportation() {
    }

    public Transportation(String licensePlates, int year, String manufacturer, String owner) {
        this.licensePlates = licensePlates;
        this.year = year;
        this.manufacturer = manufacturer;
        this.owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
