package _3_Array.exercise;

import java.util.Scanner;

public class bt_total_Of_colums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Set array tow-way.
        System.out.println("Enter size array one-way:");
        int length1 = input.nextInt();
        System.out.println("Enter size array tow-way:");
        int length2 = input.nextInt();
        int[][] arr = new int[length1][length2];
        //Enter value to array.
        for( int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
                System.out.println("Enter value arr["+i+"]["+j+"]");
                arr[i][j] = input.nextInt();
            }
        }
        //print arr.
        for( int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
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
        //math total of colums.
        System.out.println("Enter index colum.");
        int index = input.nextInt();
        int total = 0;
        for( int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                total += arr[i][index];
            }
        }
        System.out.println("Tutal for index: "+index+" is: "+total);
    }
}
