package _19_stringAndRegex.practice.p2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountExample accountExample = new AccountExample();
        /*  Không chứa các ký tự đặc biệt
	        Phải dài hơn 6 ký tự
	        Không chứa các ký tự viết hoa
	        Cho phép dấu gạch dưới (_)
	    */
        System.out.println("Nhập tên tài khoản");
        String regex = scanner.nextLine();
        if(accountExample.validate(regex)) {
            System.out.println("Thành công");
        }else {
            System.out.println("Lỗi, hãy nhập lại");
        }
        /*
        123abc_; _abc123; ______; 123456; abcdefgh  --> true

        .@ ; 12345 ; 1234_ ; abcde
        */
    }
}
