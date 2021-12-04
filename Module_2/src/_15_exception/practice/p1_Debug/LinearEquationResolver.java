package _15_exception.practice.p1_Debug;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Cho một phương trình là 'a * x + b = 0', hãy nhập các hằng số:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();

        if (a != 0) {
            double solution = -b / a;
            System.out.printf("phương trình có nghiệm duy nhất x = "+ solution);
        } else {
            if (b == 0) {
                System.out.print("phương trình có vô số nghiệm.");
            } else {
                System.out.print("phương trình vô nghiệm.");
            }
        }
    }
}
