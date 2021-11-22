package _8_cleanCode.practice.cylinder;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double volume = getPerimeter(radius) * height + 2 * getBaseArea(radius);
        return volume;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }
}
