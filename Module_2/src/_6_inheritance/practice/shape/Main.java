package _6_inheritance.practice.shape;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }
        };
        System.out.println(shape);

        shape = new Shape("red", false) {
            @Override
            public double getArea() {
                return 0;
            }
        };
        System.out.println(shape);

        //
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }
}
