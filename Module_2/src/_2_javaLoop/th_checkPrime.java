package _2_javaLoop;

import java.util.Scanner;

public class th_checkPrime {
    public static void main(String[] args) {
        System.out.println("Enter number: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        if(checkPrime(a)) {
            System.out.println(a + " is prime!");
        }else {
            System.out.println(a + " is not prime!");
        }
    }
    public static boolean checkPrime(int number) {
        boolean check = true;
        if (number < 2) {
            check = false;
        } else {
            int i = 2;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
        }return check;
    }
}
