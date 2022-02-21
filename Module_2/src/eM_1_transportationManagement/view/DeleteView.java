package transportationManagement.view;

import transportationManagement.controller.BikeController;
import transportationManagement.controller.CarController;
import transportationManagement.controller.TruckController;

import java.util.Scanner;

public class DeleteView {
    private static Scanner scanner = new Scanner(System.in);

    public static void deleteMenu() {
        boolean check = true;
        while (check) {
            try {
                System.out.println("Chọn loại phương tiện: \n" +
                        "1. Xóa xe ô tô.\n" +
                        "2. Xóa xe tải.\n" +
                        "3. Xóa xe máy.\n" +
                        "4. Quay lại menu");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        CarController.delete();
                        break;
                    case 2:
                        TruckController.delete();
                        break;
                    case 3:
                        BikeController.delete();
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
