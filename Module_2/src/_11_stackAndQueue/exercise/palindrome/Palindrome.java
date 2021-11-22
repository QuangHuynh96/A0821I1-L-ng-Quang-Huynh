package _11_stackAndQueue.exercise.palindrome;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Stack<String> stack= new Stack<>();
        Queue<String> queue= new LinkedList<>();
//   nạp và tách chuỗi ra thành từng từ.
       String[] input = new Scanner(System.in).nextLine().split("");
        int length= input.length;
        for( int i= 0; i< length; i++) {
            stack.push(input[i]);
            queue.add(input[i]);
        }
//  so sánh
        boolean check= false;
        for( int j= 0; j < length; j++) {
            if(stack.pop().equals(queue.remove())){
                check= true;
            }
        }
//        xuất kết quả
        if( check) {
            System.out.println("chuỗi nhập vào là Palindrome!");
        }else {
            System.out.println("chuỗi nhập vào ko phải Palindrome!");
        }
    }

}
