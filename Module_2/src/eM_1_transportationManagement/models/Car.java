package transportationManagement.models;

import transportationManagement.util.ConstantUtil;

public class Car extends Transportation{
    private int slot;
    private ConstantUtil.TypeCar typeCar;

    public Car() {
    }

    public Car(String licensePlates, int year, String manufacturer, String owner, int slot, ConstantUtil.TypeCar typeCar) {
        super(licensePlates, year, manufacturer, owner);
        this.slot = slot;
        this.typeCar = typeCar;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public ConstantUtil.TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(ConstantUtil.TypeCar typeCar) {
        this.typeCar = typeCar;
    }
    public String toString() {
        return this.getLicensePlates()+","+
                this.getManufacturer()+","+
                this.getYear()+","+
                this.typeCar+","+
                this.getOwner()+","+
                this.slot;
    }
}
