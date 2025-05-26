package com.pluralsight.userinterface;

import com.pluralsight.models.Order;

import java.util.Scanner;

public class UserInterface {

    //
    private Scanner scanner;

    //
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    //
    public void run() {
        boolean running = true;
        while (running) {
            int choice = showHomeScreen();
            switch (choice) {
                case 1 -> startNewOrder();
                case 0 -> running = false;
                default -> System.out.println("Invalid input! Please try again.");
            }
        }
    }

    //
    private int showHomeScreen() {
        System.out.println("\n=== Bread 'n Bytes Home ===");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Select an option (1 or 0): ");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    //
    private void startNewOrder() {
        //
        Order currentOrder = new Order();
        boolean ordering = true;
        //
        while (ordering) {
            int choice = showOrderMenu();
            switch (choice) {
                case 1 -> addingSandwich();
                case 2 -> addingDrink();
                case 3 -> addingChips();
                case 4 -> checkingOut();
                          ordering = false;
                case 0 -> System.out.println("Order Cancelled.");
                          currentOrder = null;
                          ordering = false;
                default -> System.out.println("Invalid input! Please try again.");
            }
        }
    }

    //
    private int showOrderMenu() {
        System.out.println("\n=== Order Menu ===");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Select an option (0-4): ");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
