package _1_Introduction_to_Java;

import java.util.Scanner;

public class th_check_year {
    public static void main(String[] args) {
        System.out.println("enter year:");
        Scanner input = new Scanner(System.in);
         int year = input.nextInt();

         if(year % 4 == 0) {
             if(year % 100 != 0) {
                 System.out.println(year+" la nam nhuan!");
             }else {
                 if( year % 400 != 0) {
                     System.out.println(year+" ko phai la nam nhuan!");
                 }else {
                     System.out.println(year+" la nam nhuan!");
                 }
             }
         }else {
             System.out.println(year+" ko phai la nam nhuan!");
         }
    }
}
