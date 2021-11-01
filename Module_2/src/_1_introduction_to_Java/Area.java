package _1_introduction_to_Java;

import java.util.Scanner;

public class Area {
    public static void main( String[] args) {
        float dai;
        float rong;
        Scanner input = new Scanner(System.in);// tạo lớp Scanner

        System.out.println("Nhap chieu dai: ");
        dai = input.nextFloat();// nhập chiều dài

        System.out.println("Nhap chieu rong: ");
        rong = input.nextFloat();// nhập chiều dài

        float area = rong * dai;
        System.out.println("Area is: " + area);

    }
}
