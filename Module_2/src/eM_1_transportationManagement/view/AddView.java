package transportationManagement.view;

import transportationManagement.controller.BikeController;
import transportationManagement.controller.CarController;
import transportationManagement.controller.TruckController;

import java.util.Scanner;

public class AddView {
    private static Scanner scanner = new Scanner(System.in);

    public static void addMenu() {
        boolean check = true;
        while (check) {
            try {
                System.out.println("Chọn loại phương tiện muốn thêm mới: \n" +
                        "1. Thêm mới xe ô tô.\n" +
                        "2. Thêm mới xe tải.\n" +
                        "3. Thêm mới xe máy.\n" +
                        "4. Quay lại menu");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        CarController.add();
                        break;
                    case 2:
                        TruckController.add();
                        break;
                    case 3:
                        BikeController.add();
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
