package _14_soft.exercise.e1;

import java.util.Scanner;

public class InsertionSortByStep {
    public static int[] insertionSort(int[] array){
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("Nhập "+length+" giá trị cho mảng:");
        for( int i = 0; i< length; i++) {
            System.out.print("array["+i+"] =");
            array[i] = scanner.nextInt();
        }
        // hiển thị mảng.
        for( int i: array)
            System.out.print(i+",");
        System.out.println();
        insertionSort(array);
        for( int i: array)
            System.out.print(i+",");
    }
}
