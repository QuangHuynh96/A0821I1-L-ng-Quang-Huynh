package _2_javaLoop;


import java.util.Scanner;

public class TinhLaiSuat {
    public static void main(String[] args) {
        double interestRate ;
        double money ;
        int month ;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter money: ($)");
        money = input.nextDouble();//số tiền vay

        System.out.println("Enter month: ");
        month = input.nextInt();//tháng vay

        System.out.println("Enter interestRate: (%)");
        interestRate = input.nextDouble();//lãi xuất

        double totalInterest = 0;
        for(int i = 0; i < month; i++) {
            totalInterest += money*((interestRate/100)/12)*month;
        }
        System.out.println("totalInterest is: "+totalInterest+"$");
    }
}
