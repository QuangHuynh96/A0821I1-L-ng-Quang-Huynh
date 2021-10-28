package _1_Introduction_to_Java;

import java.util.Scanner;

public class bt_display_hello {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello: "+ name);
    }
}
