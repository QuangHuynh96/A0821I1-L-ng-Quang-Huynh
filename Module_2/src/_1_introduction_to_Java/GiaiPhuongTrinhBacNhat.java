package _1_introduction_to_Java;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        System.out.println("phuong trinh ax + b = c, enter de nhạp gia tri");

        Scanner input = new Scanner(System.in);

        System.out.println("Nhap hang so a:");
        double a = input.nextDouble();

        System.out.println("Nhap hang so b:");
        double b = input.nextDouble();

        System.out.println("Nhap hang so c:");
        double c = input.nextDouble();

        double x;
        if(a != 0) {
            x = (c - b) / a;
            System.out.println("phuong trinh co nghiem la: x = "+ x);
        } else {
            if( b == c) {
                System.out.println("phuong trinh co vo so nghiem");
            }else {
                System.out.println("puong trinh vo nghiem");
            }
        }
    }
}
