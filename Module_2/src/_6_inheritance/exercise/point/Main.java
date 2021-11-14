package _6_inheritance.exercise.point;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D point1 = new Point2D(5,6);
        System.out.println(Arrays.toString(point1.getXY()));
        System.out.println(point1.toString());

        Point2D point2 = new Point3D(5,6,7);
        System.out.println(Arrays.toString(((Point3D) point2).getXYZ()));
        System.out.println(point2.toString());

    }
}
