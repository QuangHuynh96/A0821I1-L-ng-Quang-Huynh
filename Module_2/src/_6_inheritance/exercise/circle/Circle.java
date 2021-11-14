package _6_inheritance.exercise.circle;

public class Circle {
    private final double PI= 3.14;
    private double radius;
    private String color;

    public Circle() {}

    public Circle(double radius, String color) {
        this.color= color;
        this.radius= radius;
    }

    public String getColor() {
        return this.color;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return PI*radius*radius;
    }

    public void setColor( String color) {
        this.color= color;
    }

    public void setRadius(double radius) {
        this.radius= radius;
    }

    @Override
    public String toString() {
        return "color: "+this.getColor()
                +", radius: "+this.getRadius()
                +", Area: "+this.getArea();
    }
}
