package _3_arrayAndMethod.exercise;

import java.util.Scanner;

public class SearchMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Enter size for arr
        System.out.println("Enter a size for arr:");
        int N = input.nextInt();
        //Enter element for array
        int[] arr = new int[N];
        for( int i = 0; i < arr.length; i++) {
            System.out.println("Enter a arr["+i+"]:");
            arr[i] = input.nextInt();
        }

        //run function minvalue.
        System.out.println("The smallest element in the array is: " + arr[minValue(arr)]);
    }
    //hàm tìm min.
    public static int minValue(int[] array){
        int index = 0;
        for (int i = 1; i < array.length; i++){
            if(array[i] < array[index]){
                index = i;
            }
        }
        return index;
    }
}
