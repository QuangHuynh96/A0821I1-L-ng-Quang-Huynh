package _11_stackAndQueue.exercise.o_p3;

import java.util.Scanner;
import java.util.Stack;

public  class CheckByStack {
     static boolean check(String input){
         String[] array= input.split("");
         Stack<String> bStack = new Stack<String>();
         for( String sym : array) {
             if (sym.equals("(")) {
                 bStack.push(sym);
             }
             else if (sym.equals(")")) {
                 if (bStack.isEmpty())
                     return false;
                 String left = bStack.pop();
                 if (left.equals(sym))
                     return false;
                 }
             }
         return true;
    }
    public static void main(String[] args) {
        System.out.println("Nhập biểu thức: ");
        String input = (new Scanner(System.in).nextLine());
        System.out.println(CheckByStack.check(input));
    }
}
