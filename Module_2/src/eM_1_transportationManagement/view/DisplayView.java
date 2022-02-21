package transportationManagement.view;

import transportationManagement.controller.BikeController;
import transportationManagement.controller.CarController;
import transportationManagement.controller.TruckController;

import java.util.Scanner;

public class DisplayView {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        boolean check = true;
        while (check) {
            try {
                System.out.println("Chọn loại phương tiện: \n" +
                        "1. Hiển thị xe ô tô.\n" +
                        "2. Hiển thị xe tải.\n" +
                        "3. Hiển thị xe máy.\n" +
                        "4. Quay lại menu");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        CarController.display();
                        break;
                    case 2:
                        TruckController.display();
                        break;
                    case 3:
                        BikeController.display();
                        break;
                    case 4:
                        HomeView.homeMenu();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
