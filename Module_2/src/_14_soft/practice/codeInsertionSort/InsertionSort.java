package _14_soft.practice.codeInsertionSort;

public class InsertionSort {
    public static int[] insertionSortUp(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
        return array;
    }

    public static int[] insertionSortDown(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x > array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
        return array;
    }

    // test main
    public static void main(String[] args) {
        int[] array = { 1,3,5,4,8,9,2,5,4};
        insertionSortUp(array);
        for( int i : array) {
            System.out.print(i+",");
        }
        System.out.println();
        insertionSortDown(array);
        for( int i : array) {
            System.out.print(i+",");
        }
    }
}
