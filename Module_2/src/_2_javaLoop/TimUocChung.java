package _2_javaLoop;

import java.util.Scanner;

public class TimUocChung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number a:");
        int a = Math.abs(input.nextInt());
        System.out.println("Enter number b:");
        int b = Math.abs(input.nextInt());

        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }else {
            while (a != b) {
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            }
            System.out.println("Greatest common factor: " + a);
        }

    }
}
