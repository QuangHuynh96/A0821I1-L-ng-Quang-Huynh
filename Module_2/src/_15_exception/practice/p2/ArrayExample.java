package _15_exception.practice.p2;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom() {
        Random random = new Random();
        Integer[] array = new Integer[100];
        for( int i= 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i]+ ",");
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] array = arrayExample.createRandom();
        System.out.println();
        for( Integer i : array) {
            System.out.print( i + ",");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chỉ số của một phần tử bất kì: ");
        int index = scanner.nextInt();
        try{
            System.out.println("Giá trị của phần tử có chỉ số " + index + " là " + array[index]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Chỉ số vượt quá giới hạn của mảng.");
        }
    }
}
