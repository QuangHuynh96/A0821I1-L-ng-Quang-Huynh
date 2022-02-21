package transportationManagement.controller;

import transportationManagement.service.TruckService;
import transportationManagement.service.impl.TruckServiceImpl;

import java.util.Scanner;

public class TruckController {
    private static TruckService truckService = new TruckServiceImpl();
//    private Scanner scanner = new Scanner(System.in);

    public static void add() {
        truckService.add();
    }
    public static void display() {
        truckService.display();
    }
    public static void delete() {
        truckService.delete();
    }
}
