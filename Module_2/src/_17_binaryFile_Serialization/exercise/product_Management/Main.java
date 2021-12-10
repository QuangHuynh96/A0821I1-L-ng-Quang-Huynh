package _17_binaryFile_Serialization.exercise.product_Management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Welcom e to the product manager programe!");
            System.out.println("1. thêm sản phẩm.");
            System.out.println("2. Tìm sản phẩm.");
            System.out.println("3. Hiển thị danh sách sản phẩm.");
            System.out.println("4. Thêm sản phẩm từ file.");
            System.out.println("5. Xuất file sản phẩm.");
            System.out.println("6. Xóa danh sách sản phẩm.");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    System.out.println("Nhập mã sản phẩm cần tim:");
                    productManager.search(scanner.nextInt());
                    break;
                case 3:
                    productManager.display();
                    break;
                case 4:
                    System.out.println("Nhập đường dẫn file:");
                    //_17_binaryFile_Serialization/exercise/product_Management/phoneData.txt
                    productManager.readFile(scanner.nextLine());
                    break;
                case 5 :
                    System.out.println("Nhập tên file:");
                    productManager.writeFile(scanner.nextLine());
                    break;
                case 6 :
                    productManager.clear();
            }
        }
    }

}

