package _6_inheritance.exercie.circle;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {}

    public Cylinder(double height) {
        this.height= height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height= height;
    }

    public void setHeight( double height) {
        this.height= height;
    }

    public double getHeight() {
        return this.height;
    }

    public double getVolume() {
        return this.getArea()*getHeight();
    }

    @Override
    public String toString() {
        return "color: "+this.getColor()
                +", radius: "+this.getRadius()
                +", height: "+this.getHeight()
                +", Volume: "+this.getVolume();
    }
}
