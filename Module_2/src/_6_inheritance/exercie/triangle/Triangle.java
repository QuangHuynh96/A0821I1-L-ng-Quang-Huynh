package _6_inheritance.exercie.triangle;

import _6_inheritance.practice.shape.Shape;

public class Triangle extends Shape {
    private double side1= 1.0;
    private double side2= 1.0;
    private double side3= 1.0;

    public Triangle() {}

    public Triangle(double side1, double side2, double side3) {
        this.side1= side1;
        this.side2= side2;
        this.side3= side3;
    }

    public Triangle(String color, boolean filled,double side1, double side2, double side3) {
        super(color, filled);
        this.side1= side1;
        this.side2= side2;
        this.side3= side3;

    }

    public void setSide1(double side1) {
        this.side1= side1;
    }

    public void setSide2(double side2) {
        this.side2= side2;
    }

    public void setSide3(double side3) {
        this.side3= side3;
    }

    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public double getPerimeter() {
        return this.getSide1()+this.getSide2()+this.getSide3();
    }
//S = √p x (p – a) x (p – b) x ( p – c)--công thúc heron để tính S tam giác.
    public double getArea() {
        double area;
        double p= this.getPerimeter()/2;
        area= Math.sqrt(p*(p-this.side1)*(p-this.side2)*(p-this.side3));
        return area;
    }

    @Override
    public String toString() {
        if(this.filled == true) {
            return "A Triangle with color of "+this.getColor()+" and filled"
                    +", Area:"+getArea()
                    +", Perimeter:"+getPerimeter();
        }else {
            return "A Triangle with color of "+this.getColor()+" and not filled"
                    +", Area:"+getArea()
                    +", Perimeter:"+getPerimeter();
        }
    }
}
