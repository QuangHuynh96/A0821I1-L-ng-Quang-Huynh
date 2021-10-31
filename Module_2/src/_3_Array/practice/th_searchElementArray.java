package _3_Array.practice;

import java.util.Scanner;

public class th_searchElementArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //nạp độ dài mản.
        System.out.println("Enter a size for arr:");
        int size = input.nextInt();
        int[] arr;

        //nạp element cho array.
        arr = new int[size];
        for( int i = 0; i < arr.length; i++) {
            System.out.println("Enter a arr["+i+"]:");
            arr[i] = input.nextInt();
        }

        //nạp element cần tim.
        System.out.println("Enter name search: ");
         int search = input.nextInt();

        //Search index of element in array.
        boolean check = true;
        int index = 0;
        for( int j = 0; j < arr.length; j++) {
            if( arr[j] == search) {
                index = j;
                check = true;
                break;
            }else {
                check = false;
            }
        }
        if(check) {
            System.out.println("Name: "+search+" have a first index: "+ index);
        }else {
            System.out.println("Name: "+search+" is not in array");
        }
    }
}
