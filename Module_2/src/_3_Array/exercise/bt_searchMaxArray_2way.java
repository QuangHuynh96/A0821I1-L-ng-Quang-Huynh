package _3_Array.exercise;

import java.util.Scanner;

public class bt_searchMaxArray_2way {
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
        //search max.
        int a = 0;
        int b = 0;
        int max = arr[a][b];
        for( int u = 0 ; u < arr.length; u++) {
            for(int h = 0; h < arr[u].length; h++) {
               if( arr[u][h] > max) {
                    max = arr[u][h];
                    a = u;
                    b= h;
                }
            }
        }
        System.out.println("max: "+"arr["+a+"]["+b+"] = "+max);

    }
}