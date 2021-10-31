package _3_Array.practice;

import java.util.Scanner;

public class th_changeTemperature {
    public static void main(String[] args) {
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Exit");

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        switch(number) {
            case 1:
                System.out.println("Fahrenheit : ");
                double fahrenheit = input.nextDouble();
                Fahrenheit_to_Celsius(fahrenheit);
                break;
            case 2:
                System.out.println("Celsius : ");
                double celsius = input.nextDouble();
                Celsius_to_Fahrenheit(celsius);
                break;
            case 3:
                System.out.println("Program end.");
                break;
        }
    }
//hàm chuyển C sang F.
    public static void Fahrenheit_to_Celsius(double input) {
        double celsius = (5.0 / 9)*(input - 32);
        System.out.println("Celsius: "+celsius+"C");
    }
// hàm chuyển F sang C.
    public static void Celsius_to_Fahrenheit(double input) {
        double fahrenheit = input/(5.0 / 9)+32;
        System.out.println("Fahrenheit: "+fahrenheit+"F");

    }
}
