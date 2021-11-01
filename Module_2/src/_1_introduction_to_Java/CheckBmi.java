package _1_introduction_to_Java;

import java.util.Scanner;

public class CheckBmi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("enter weight: (kg)");
        double weight = input.nextDouble();

        System.out.println("Enter height: (m)");
        double height = input.nextDouble();

        double bmi = weight/Math.pow(height, 2);

        if(bmi < 18.5) {
            System.out.println("Underwweight");
        }else if( bmi < 25.0) {
            System.out.println("Normal");
        }else if( bmi < 30.0) {
            System.out.println("Overweight");
        }else {
            System.out.println("Obese");
        }
    }
}