package _1_Introduction_to_Java;

import java.util.Scanner;

public class bt_rateMoney {
    public static void main(String[] args) {
        int rate = 23000;

        System.out.println("Enter the USD:");
        Scanner input = new Scanner(System.in);
         int usd = input.nextInt();

         int outPut = usd * rate;
         System.out.println(usd + "$ = "+ outPut + " VND");
    }
}
