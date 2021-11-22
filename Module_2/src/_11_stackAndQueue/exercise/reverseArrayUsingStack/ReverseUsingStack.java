package _11_stackAndQueue.exercise.reverseArrayUsingStack;

import java.util.Stack;

public class ReverseUsingStack<E> {

//Đảo integer.
    public static int[] ReverseInteger(int[] array) {
        int size= array.length;
        Stack<Integer> reverse = new Stack<Integer>();
        for( int i= 0; i< size; i++) {
            reverse.push(array[i]);
        }
        for( int i= 0; i< size; i++) {
            array[i]= reverse.pop();
        }
        return array;
    }
//Đảo String.
    public static String ReverseString(String string) {
        String result= "";
        int size= string.length();
        String[] arrayString= string.split("");
        Stack<String> reverse = new Stack<String>();
        for( int i= 0; i< size; i++) {
            reverse.push(arrayString[i]);
        }
        for( int i= 0; i< size; i++) {
            result += reverse.pop();
        }
        return result;
    }

// Run method.
    public static void main(String[] args) {
        int[] arrayNumber= new int[5];
        for( int i= 0; i< arrayNumber.length; i++) {
            arrayNumber[i]= i+1;
        }
        ReverseInteger(arrayNumber);
        for( int i= 0; i< arrayNumber.length; i++) {
            System.out.println(arrayNumber[i]);
        }
        System.out.println(ReverseString("abc"));

    }

}
