package _1_introduction_to_Java;

import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap thang muon kiem tra");
        byte month = input.nextByte();
        switch(month) {
            case 2:
                System.out.println("tháng "+month+" có 28 hoac 29 ngay");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("thang "+ month +" co 31 ngay");
                break;
            default:
                System.out.println("thang "+ month +" co 30 ngay");
        }
    }
}
