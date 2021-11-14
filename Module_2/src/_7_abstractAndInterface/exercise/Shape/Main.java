package _7_abstractAndInterface.exercise.Shape;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape2[] shapes = new Shape2[3];
        shapes[0] = new Circle2();
        shapes[1] = new Rectangle2();
        shapes[2] = new Square2();

        shapes[0].resize(3.5);
        shapes[1].resize(3.0);
        shapes[2].resize(4.5);

        for(int i= 0; i < shapes.length; i++) {
            if( shapes[i] instanceof Square2) {
                System.out.println(((Square2) shapes[i]).howToColor());
            }else {
                System.out.println(shapes[i]);
            }
        }
    }
}
