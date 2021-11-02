package _4_classAndObject.practice.rectangle;

public class Rectangle {
    double height;
    double width;

    public Rectangle() {

    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        double area = this.height * this.width;
        return area;
    }

    public double getPerimeter() {
        double primeter = (this.height + this.width) * 2;
        return primeter;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
