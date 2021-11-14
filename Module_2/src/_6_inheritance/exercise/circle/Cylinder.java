package _6_inheritance.exercise.circle;

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
        return super.getArea()*getHeight();
    }

    @Override
    public String toString() {
        return "color: "+super.getColor()
                +", radius: "+super.getRadius()
                +", height: "+ getHeight()
                +", Volume: "+ getVolume();
    }
}
