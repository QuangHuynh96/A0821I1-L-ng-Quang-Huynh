package _19_stringAndRegex.exercise.validateClassName;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassNameExample classNameExample = new ClassNameExample();
        System.out.println("Nhập tên lớp:");
        String regex = scanner.nextLine();

        if(classNameExample.validate(regex)) {
            System.out.println("Thành công");
        }else {
            System.out.println("Lỗi, hãy nhập lại");
        }
    }
}
