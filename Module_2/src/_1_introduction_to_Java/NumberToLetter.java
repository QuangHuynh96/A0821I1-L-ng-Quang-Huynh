package _1_introduction_to_Java;

import java.util.Scanner;

public class NumberToLetter {
    public static void main(String[] args) {
        System.out.println("Enter number:");
        Scanner input = new Scanner(System.in);
        int height = input.nextInt();

        String check = Integer.toString(height);
        String[] letter_1 = {"zero","one","twelve","thirty","forty","fifty","sixty","seventies","eighty","nicety"};
        String[] letter_2 = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","niceteen"};

        char a = check.charAt(0);
        char b = check.charAt(1);
        char c = check.charAt(2);
        int A = Integer.parseInt(String.valueOf(a));
        int B = Integer.parseInt(String.valueOf(b));
        int C = Integer.parseInt(String.valueOf(c));

        if(height < 20) {
            System.out.println(letter_2[height]);
        }else if(height < 100) {
            String result = letter_1[A] +" "+ letter_2[B];
            System.out.println(result);
        }else {
            if ( B == 1) {
                String result = letter_2[A] +" hundred "+ letter_2[C + 10];
                System.out.println(result);
            }else {
                String result = letter_2[A] +" hundred "+ letter_1[B] +" "+ letter_2[C];
                System.out.println(result);
            }
        }
    }
}