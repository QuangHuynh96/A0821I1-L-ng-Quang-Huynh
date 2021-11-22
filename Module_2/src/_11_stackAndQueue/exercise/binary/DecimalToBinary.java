package _11_stackAndQueue.exercise.binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> binary= new Stack<>();
        System.out.println("Nhập số nguyên");
        int number= input.nextInt();

        while( number!= 0) {
            binary.push(number%2);
            number= number/2;
        }
        for( int i= 0; i< binary.size(); i++) {
            System.out.print(binary.get(i));
        }
        binary.clear();
    }
}
