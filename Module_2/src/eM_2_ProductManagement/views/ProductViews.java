package exerciseMore.views;

import exerciseMore.service.GenuineProductService;
import exerciseMore.service.HandedProductService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductViews {
    private static GenuineProductService genuineProductService = new GenuineProductService();
    private static HandedProductService handedProductService = new HandedProductService();
     private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
            mainMenu();
    }
    public static void mainMenu() {
        genuineProductService.readFileGenuine();
        handedProductService.readFileHanded();
        boolean check = true;
        while(check) {
            System.out.println("1. Genuine product manage.");
            System.out.println("2. Handed product manage.");
            System.out.println("3. Show product list.");
            System.out.println("4. Exit.");
            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        menuGenuineProductManage();
                        break;
                    case 2:
                        menuHandedProductManage();
                        break;
                    case 3:
                        showAllProduct();
                        break;
                    case 4:
                        check = false;
                        System.out.println("kết thúc chương trình.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập!");
            }
        }
    }

    public static void menuGenuineProductManage() {
        boolean check = true;
        while(check) {
            System.out.println("1. Add new genuine product.");
            System.out.println("2. Delete genuine product.");
            System.out.println("3. search genuine product.");
            System.out.println("4. display  genuine product.");
            System.out.println("5. Back menu.");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    genuineProductService.add();
                    genuineProductService.writeFile("exerciseMore/data/genuineProductList.csv");
                    break;
                case 2:
                    System.out.println("Nhập id sản phẩm cần xóa:");
                    genuineProductService.delete(scanner.nextInt());
                    genuineProductService.writeFile("exerciseMore/data/genuineProductList.csv");
                    break;
                case 3:
                    System.out.println("Nhập tên sản phẩm:");
                    genuineProductService.search(scanner.nextLine());
                    break;
                case 4:
                    genuineProductService.display();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Lỗi: Nhập sai chức năng.");
            }
        }

    }
    public static void menuHandedProductManage() {
        boolean check = true;
        while(check) {
            System.out.println("1. Add new handed product.");
            System.out.println("2. Delete handed product.");
            System.out.println("3. search handed product.");
            System.out.println("4. display handed product.");
            System.out.println("5. Back to menu.");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    handedProductService.add();
                    handedProductService.writeFile("exerciseMore/data/handedProductList.csv");
                    break;
                case 2:
                    System.out.println("Nhập id sản phẩm cần xóa:");
                    handedProductService.delete(Integer.parseInt(scanner.nextLine()));
                    handedProductService.writeFile("exerciseMore/data/handedProductList.csv");
                    break;
                case 3:
                    System.out.println("Nhập tên sản phẩm:");
                    String name = scanner.nextLine();
                    handedProductService.search(name);
                    break;
                case 4:
                    handedProductService.display();
                    break;
                case 5:
                    mainMenu();
                    break;
            }
        }
    }
    public static void showAllProduct() {
        handedProductService.display();
        System.out.println("-----------------------------");
        genuineProductService.display();
    }
//    public static List<String> readFile(String path) {
//        List<String> list = new ArrayList<>();
//        try{
//            FileReader fr = new FileReader(path);
//            BufferedReader br = new BufferedReader(fr);
//            String line = "";
//            while (true) {
//                line = br.readLine();
//                if (line == null) {
//                    break;
//                }
//                list.add(line);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
