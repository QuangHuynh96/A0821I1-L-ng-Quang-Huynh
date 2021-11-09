package _6_inheritance.exercie.triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter weight a:");
        double a= input.nextDouble();
        System.out.println("Enter weight b:");
        double b= input.nextDouble();
        System.out.println("Enter weight c:");
        double c= input.nextDouble();
        System.out.println("Enter the color to triangle");
        String color = input.next();
        //System.out.println(" Enter the fill: true or false");
        //boolean filled = input.hasNextBoolean();
        int fill;
        boolean filled= false;
        do {
            System.out.println("Enter the filled: 1 to true, 2 to false.");
            fill = input.nextInt();
            switch(fill) {
                case 1:
                    filled = true;
                    break;
                case 2:
                    filled = false;
                    break;
            }
        }while((fill!= 1) && (fill!= 2));

        Triangle tamgiac1= new Triangle(color,filled,a,b,c);
        System.out.println(tamgiac1.toString());
    }
}
