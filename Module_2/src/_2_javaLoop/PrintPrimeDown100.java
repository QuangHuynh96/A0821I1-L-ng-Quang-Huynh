package _2_javaLoop;

import java.util.Scanner;

public class PrintPrimeDown100 {
    public static void main(String[] args) {
        for( int i = 1; i <= 100; i++) {
            if(checkPrime(i)) {//kiểm tra số bằng hàm checkPrime.
                System.out.println(i);
            }
        }
    }
// hàm kiểm tra số nguyên tố.
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
