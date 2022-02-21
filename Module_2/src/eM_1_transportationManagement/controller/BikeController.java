package transportationManagement.controller;

import transportationManagement.service.BikeService;
import transportationManagement.service.impl.BikeServiceImpl;

import java.util.Scanner;

public class BikeController {
    private static BikeService bikeService = new BikeServiceImpl();
//    private Scanner scanner = new Scanner(System.in);

    public static void add() {
        bikeService.add();
    }
    public static void display() {
        bikeService.display();
    }
    public static void delete() {
        bikeService.delete();
    }
}
