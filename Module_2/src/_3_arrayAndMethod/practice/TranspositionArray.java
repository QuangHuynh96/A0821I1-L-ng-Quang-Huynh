package _3_arrayAndMethod.practice;

import java.util.Scanner;
// đảo mảng
public class TranspositionArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr;
        int size;

        //xét điều kiện độ dài < 20.
        do {
            System.out.println("Enter a size for arr:");
            size = input.nextInt();
            if(size > 20 ) {
                System.out.println("Must: Size < 20");
            }
        }while(size > 20 );

        //nạp element cho array.
        arr = new int[size];
        for( int i = 0; i < size; i++) {
            System.out.println("Enter a arr["+i+"]:");
            arr[i] = input.nextInt();
        }

        //đảo array
        for( int j = 0; j < arr.length/2; j++) {
            int temp = arr[j];
            arr[j] = arr[arr.length -1 - j];
            arr[arr.length -1 - j] = temp;
        }
        //in ra mảng đã đảo
        for(int u = 0; u < arr.length; u++) {
            System.out.println("arr["+u+"]: "+ arr[u]);
        }
   }
}
