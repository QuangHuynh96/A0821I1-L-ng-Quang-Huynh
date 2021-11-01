package _3_arrayAndMethod.exercise;

import java.util.Scanner;

public class TotalDiagonalLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Set array tow-way.
        System.out.println("Enter size array tow-way:");
        int arr_length = input.nextInt();

        int[][] arr = new int[arr_length][arr_length];
        //Enter value to array.
        for( int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println("Enter value arr["+i+"]["+j+"]");
                arr[i][j] = input.nextInt();
            }
        }
        //print arr.
        for( int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if( arr[i][j] < 10) {
                    System.out.print(arr[i][j]+"   ");
                }else if( arr[i][j] < 100) {
                    System.out.print(arr[i][j]+"  ");
                }else {
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
        //math total cross.
        int total_1 = 0;
        int total_2 = 0;
        for( int i = 0; i < arr_length; i++) {
            for(int j = 0; j < arr_length; j++) {
                if( i == j ) {
                    total_1 += arr[i][j];
                }
                if( j == arr_length - 1 -i) {
                    total_2 += arr[i][j];
                }
            }
        }
        System.out.println("total diagonal_line 1: "+total_1);
        System.out.println("total diagonal_line 2: "+total_2);
    }
}
