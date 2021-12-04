package _14_soft.practice.codeSelectionSort;

public class SelectionSort {
    public static int[] selectionSortUp(int[] arr) {
        int length = arr.length;
        for( int i= 0; i < length; i++) {
            for(int j = i +1; j < length; j++) {
                if( arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSortDown(int[] arr) {
        int length = arr.length;
        for( int i= 0; i < length; i++) {
            for(int j = i +1; j < length; j++) {
                if( arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = { 1,3,5,4,8,9,2,5,4};
        selectionSortUp(array);
        for( int i : array) {
            System.out.print(i+",");
        }
        System.out.println();
        selectionSortDown(array);
        for( int i : array) {
            System.out.print(i+",");
        }

    }

}
