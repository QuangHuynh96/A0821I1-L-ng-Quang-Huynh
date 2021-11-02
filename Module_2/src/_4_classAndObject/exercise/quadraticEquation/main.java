package _4_classAndObject.exercise.quadraticEquation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("for ax2 + bx + c = 0");
        System.out.println("Enter a: ");
        double a = input.nextDouble();
        System.out.println("Enter b: ");
        double b = input.nextDouble();
        System.out.println("Enter c: ");
        double c = input.nextDouble();

        QuadraticEquation pt1 = new QuadraticEquation(a, b, c);

        if( pt1.getDiscriminant() > 0 ) {
            System.out.println("root 1: "+ pt1.getRoot1());
            System.out.println("root 2: "+ pt1.getRoot2());
        } else if( pt1.getDiscriminant() == 0) {
            System.out.println("double roots: "+ pt1.getRoot1());
        }
        else {
            System.out.println("The equation has no roots.");
        }
    }
}
