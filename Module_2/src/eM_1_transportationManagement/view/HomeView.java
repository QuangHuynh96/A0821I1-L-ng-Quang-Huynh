package transportationManagement.view;

import java.util.Scanner;

public class HomeView {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        homeMenu();
    }
    public static void homeMenu() {
        boolean check = true;
        while (check) {
            try {
                System.out.println("CHUONG TRING QUANG LY PHUONG TIEN GIAO THONG");
                System.out.println("Chọn chức năng: \n" +
                        "1. Thêm mới phương tiện.\n" +
                        "2. Hiện thị phương tiện.\n" +
                        "3. Xóa phương tiện.\n" +
                        "4. Thoát");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        AddView.addMenu();
                        break;
                    case 2 :
                        DisplayView.displayMenu();
                        break;
                    case 3 :
                        DeleteView.deleteMenu();
                        break;
                    case 4:
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
