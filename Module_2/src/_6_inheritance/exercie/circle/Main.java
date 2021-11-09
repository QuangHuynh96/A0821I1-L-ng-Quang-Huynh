package _6_inheritance.exercie.circle;

public class Main {
    public static void main(String[] args) {
        Circle hinhtron = new Circle(2.5,"black");
        System.out.println(hinhtron.toString());

        Circle hinhtru = new Cylinder(2.5, "red", 5);
        System.out.println(hinhtru.toString());
    }
}
