package _4_classAndObject.practice.rectangle;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap chieu dai");
        double height = input.nextDouble();
        System.out.println("Nhap chieu rong");
        double width = input.nextDouble();
//tạo đối tượng hình chữ nhật
        Rectangle hinhchunhat = new Rectangle(height,width);

        System.out.println("kich thuoc hinh chu nhat la: "+ hinhchunhat.display());
        System.out.println("Dien tich hinh chu nhat là: "+ hinhchunhat.getArea());
        System.out.println("Chu vi hinh chu nhat là: "+ hinhchunhat.getPerimeter());



    }
}
