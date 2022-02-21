package transportationManagement.controller;

import transportationManagement.service.CarService;
import transportationManagement.service.impl.CarServiceImpl;



public class CarController {
    private static CarService carService = new CarServiceImpl();

    public static void add() {
        carService.add();
    }

    public static void display() {
        carService.display();
    }

    public static void delete() {
        carService.delete();
    }
}
