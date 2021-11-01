package _3_arrayAndMethod.practice;

import java.util.Scanner;

public class SearchMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr;
        int size;

        //xét điều kiện độ dài < 20.
        do {
            System.out.println("Enter size for list:");
            size = input.nextInt();
            if(size > 20 ) {
                System.out.println("Size must be less than 20");
            }
        }while(size > 20 );

        //nạp element cho array.
        arr = new int[size];
        for( int i = 0; i < size; i++) {
            System.out.println("Enter a arr["+i+"]:");
            arr[i] = input.nextInt();
        }

        //search max in array
        int max = arr[0];
        for( int j = 1; j < arr.length; j++) {
            if( arr[j] > max) {
                max = arr[j];
            }
        }
        System.out.println("Max element in list is: "+ max);
    }
}
