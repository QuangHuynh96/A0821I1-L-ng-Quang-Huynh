package _19_stringAndRegex.exercise.phoneNumberExample;

import _19_stringAndRegex.exercise.validateClassName.ClassNameExample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        System.out.println("Nhập số điện thoại");
        String regex = scanner.nextLine();

        if(phoneNumberExample.validate(regex)) {
            System.out.println("Thành công");
        }else {
            System.out.println("Lỗi, hãy nhập lại");
        }
    }
}
