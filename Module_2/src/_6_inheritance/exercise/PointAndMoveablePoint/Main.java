package _6_inheritance.exercise.PointAndMoveablePoint;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(5,6);
        System.out.println(point1.toString());
        System.out.println(Arrays.toString(point1.getXY()));

        MoveablePoint point2 = new MoveablePoint(2,5,6,6);
        System.out.println(point2.toString());
        System.out.println(point2.move());
    }
}
