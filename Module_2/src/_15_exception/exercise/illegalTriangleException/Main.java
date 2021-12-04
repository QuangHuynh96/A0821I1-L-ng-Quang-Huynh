package _15_exception.exercise.illegalTriangleException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalTriangleException {
        int x,y,z;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập cạnh x: ");
        x = scanner.nextInt();
        System.out.println("nhập cạnh y: ");
        y = scanner.nextInt();
        System.out.println("nhập cạnh z: ");
        z = scanner.nextInt();
        try {
            Triangle tamgiac1 = new Triangle(x, y, z);
            System.out.println(tamgiac1.chuvi());
        } catch(IllegalTriangleException e){
            System.out.print(e.getMessage());
        }
//        Triangle tamgiac1 = new Triangle(x, y, z);
//            System.out.println(tamgiac1.chuvi());
    }
}
