package _2_javaLoop;

import java.util.Scanner;

public class bt_printpicture {
    public static void main(String[] args) {
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number:");
        int number = input.nextInt();

        switch(number) {
            case 1:
                System.out.println("Enter a long: ");
                int a = input.nextInt();
                System.out.println("Enter a wide: ");
                int b = input.nextInt();
                printRectangle(a,b);
                break;
            case 2:
                System.out.println("1. Top left");
                System.out.println("2. Top right");
                System.out.println("3. Bottom left");
                System.out.println("4. Bottom right");

                System.out.println("Enter the number:");
                int sellec = input.nextInt();

                System.out.println("Enter edge: ");
                int edge = input.nextInt();

                printSquarerTriangle(edge,sellec);
                break;
            case 3:
                System.out.println("Enter height: ");
                int height = input.nextInt();
                isoscelesTriangle(height);
                break;

            case 4:
                System.out.println("nd of program.");
                break;
        }
    }
//hàm in hình chữ nhật
    public static void printRectangle(int longs, int Wides) {
        for(int i = 0; i < Wides; i++) {
            for(int j = 0; j < longs; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
//hàm in tam giác vuông
    public static void printSquarerTriangle(int edge, int direction) {
        switch(direction) {
            case 1://top left
                for( int i1 = 0; i1 < edge; i1++) {
                    for( int j1 = 0; j1 < edge - i1 ; j1++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                break;
            case 2://top right
                for(int i2 = 0; i2 < edge; i2++) {
                    for(int j2 = 0; j2 < edge; j2++) {
                        if( j2 < i2) {
                            System.out.print("   ");
                        }else {
                            System.out.print(" * ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 3://bottom left
                for(int i3 = 0; i3 < edge; i3++) {
                    for(int j3 = 0; j3 < i3 +1; j3++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                break;
            case 4://bottom right
                for( int i4 = 0; i4 < edge; i4++) {
                    for(int j4 = 0; j4 < edge; j4++) {
                        if( j4 < edge - i4 - 1) {
                            System.out.print("   ");
                        }else {
                            System.out.print(" * ");
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }
//hàm in tam giác
    public static void isoscelesTriangle(int height) {
        int n = 2*height -1;//chiều ngang của tam giác cân
        for( int i = 0; i < height; i++) {
            for( int j = 0; j < n; j++) {
                if(j >= height-1-i && j <= height-1+i) {
                    System.out.print(" * ");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
