package _14_soft.practice.codeBubbleSort;

public class BubbleSort {
    public static int[] bubbleSortUp(int[] arr) {
        int length = arr.length;
        for( int i= 0; i < length; i++) {
            for(int j = length -1; j > i; j--) {
                if( arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSortDown(int[] arr) {
        int length = arr.length;
        for( int i= 0; i < length; i++) {
            for(int j = length -1; j > i; j--) {
                if( arr[j] > arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = { 1,3,5,4,8,9,2,5,4};
        bubbleSortUp(array);
        for( int i : array) {
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("-------");
        bubbleSortDown(array);
        for( int i : array) {
            System.out.print(i+",");
        }
    }
}
