package _3_arrayAndMethod.exercise;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Enter size for arr.1
        System.out.println("Enter a size for arr_1:");
        int N1 = input.nextInt();
        //Enter element for array.1
        int[] arr_1 = new int[N1];
        for( int i = 0; i < arr_1.length; i++) {
            System.out.println("Enter a arr_1["+i+"]:");
            arr_1[i] = input.nextInt();
        }

        //Enter size for arr.2
        System.out.println("Enter a size for arr_2:");
        int N2 = input.nextInt();
        //Enter element for array.2
        int[] arr_2 = new int[N2];
        for( int j = 0; j < arr_2.length; j++) {
            System.out.println("Enter a arr_2["+j+"]:");
            arr_2[j] = input.nextInt();
        }

        //set arr_3 = arr_1 + arr_2.
        int[] arr_3 = new int[N1+N2];
        for( int k = 0; k < N1; k ++) {
            arr_3[k] = arr_1[k];
        }
        for(int u = 0; u < N2; u++) {
            arr_3[u+N1] = arr_2[u];
        }

        //print arr.
        System.out.println("arr_3:");
        for( int l = 0; l < arr_3.length; l++) {
            System.out.print(arr_3[l]+", ");
        }System.out.println();
    }
}
