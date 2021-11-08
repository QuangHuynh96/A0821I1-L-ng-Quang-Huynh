package _5_accessModifierStatic.exercise.circle;

public class TestCircle {
    private final double PI= 3.14;
    private double darius;
    private static String color= "red";

    public TestCircle() {
        this.darius= 1.0;
    }

    public TestCircle(double r) {
        this.darius= r;
    }

    protected double getDarius() {
        return this.darius;
    }

    protected double getArea() {
        return getDarius()*getDarius()*PI;
    }
}
