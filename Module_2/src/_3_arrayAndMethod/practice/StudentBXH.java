package _3_arrayAndMethod.practice;

import java.util.Scanner;

public class StudentBXH {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        int Bxh[];
        int pass = 0;
        do{
            System.out.println("Enter a size Bxh:");
            size = input.nextInt();
            Bxh = new int[size];
            if(size > 30) {
                System.out.println("Size should not exceed 30.");
            }
        }while(size >30);

        for(int i = 0; i < Bxh.length; i++) {
            System.out.println("Enter a mark for student no."+(i+1));
            Bxh[i] = input.nextInt();
            if( Bxh[i] > 5) {
                pass++;
            }
        }
        System.out.println("The number of students passing the exam is: "+pass);

    }
}
