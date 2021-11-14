package _7_abstractAndInterface.exercise.Shape;


import _6_inheritance.practice.shape.Shape;

public class Circle2 extends Shape2 implements Resizeable{
    private double radius;

    public Circle2() {
        this.radius = 1.0;
    }

    public Circle2( double radius) {
        this.radius= radius;
    }

    public Circle2( String color, boolean filled, double radius) {
        super(color,filled);
        this.radius= radius;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
        _6_inheritance.practice.shape.Circle circle = new _6_inheritance.practice.shape.Circle();
        System.out.println(circle);

        circle = new _6_inheritance.practice.shape.Circle(3.5);
        System.out.println(circle);

        circle = new _6_inheritance.practice.shape.Circle("indigo", false, 3.5);
        System.out.println(circle);
    }

    @Override
    public void resize(double percent) {
        this.setRadius(getRadius()*percent);
    }
}

