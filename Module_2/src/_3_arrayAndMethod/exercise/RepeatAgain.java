package _3_arrayAndMethod.exercise;

import java.util.Scanner;

public class RepeatAgain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = input.nextLine();

        System.out.println("Enter char_search:");
        char n = input.next().charAt(0);
        //check
        int count = 0;
        for( int i = 0; i < str.length(); i++) {
            if( str.charAt(i) == n) {
                count++;
            }
        }
        System.out.println("String: "+str+", have: "+count+" charater "+"'"+n+"'.");
    }
}
