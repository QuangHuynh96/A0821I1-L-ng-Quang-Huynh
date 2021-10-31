package _3_Array.exercise;

import java.util.Scanner;

public class bt_pushElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Enter size for arr.
        System.out.println("Enter a size for arr:");
        int N = input.nextInt();

        //Enter element for array.
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter a arr[" + i + "]:");
            arr[i] = input.nextInt();
        }

        //print arr.
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + ", ");
        }
        System.out.println();

        //Enter insert_Element, index_element.
        System.out.println("Enter insert Element: ");
        int insert_Element = input.nextInt();
        System.out.println("Enter  Element: ");
        int index_Element = input.nextInt();

        //loop arr and insert element.
        for(int j = arr.length -1; j > index_Element; j--) {
            arr[j] = arr[j-1];
        }
        arr[index_Element] = insert_Element;

        //print array
        for( int u = 0; u < arr.length; u++) {
            System.out.print(arr[u]+", ");
        }

    }
}