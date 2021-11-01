package _2_javaLoop;

import java.util.Scanner;

public class PrintPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the quantity: ");
        int number = input.nextInt();

        int count = 0;
        for( int i = 1; count < number ; i++) {
            if(checkPrime(i)) {//kiểm tra số bằng hàm checkPrime.
                System.out.println(i);
                count++;
            }
        }
    }
// hàm check số nguyên tố.
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
