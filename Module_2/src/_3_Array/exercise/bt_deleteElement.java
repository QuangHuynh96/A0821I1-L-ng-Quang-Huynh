package _3_Array.exercise;

import java.util.Scanner;

public class bt_deleteElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Enter size for arr.
        System.out.println("Enter a size for arr:");
        int N = input.nextInt();

        //Enter element for array.
        int[] arr = new int[N];
        for( int i = 0; i < arr.length; i++) {
            System.out.println("Enter a arr["+i+"]:");
            arr[i] = input.nextInt();
        }

        //print arr.
        for( int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+", ");
        }System.out.println();

        //Enter search Element.
        System.out.println("enter the element want to delete: ");
        int search = input.nextInt();

        //loop arr: for search_index to arr.length-1.
        if(search_indexElement(arr,search) != -1 ) {
            for (int j = search_indexElement(arr, search); j < arr.length; j++) {
                if( j != arr.length -1) {
                    arr[j] = arr[j + 1];
                }else{ // khi mảng có length = 1.
                    arr[j] = 0;
                }
            }
        }else { //function return: -1 --> element isn't in array.
            System.out.println(search+" ís not in arr.");
        }

        //Print arr.
        System.out.println("Array with deleted element.");
        for( int u = 0; u < arr.length; u++) {
                System.out.print(arr[u] + ", ");
        }
    }

    //function search index_Element
    public static int search_indexElement(int[] array,int search) {
        int index= -1;
        for( int i = 0; i < array.length; i++) {
            if( array[i] == search) {
                index = i;
            }
        }
        return index;
        //giá trị ko có trong mảng thì hàm trả về -1.
    }

}
