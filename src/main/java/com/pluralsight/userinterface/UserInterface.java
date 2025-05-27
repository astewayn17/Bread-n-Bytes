package com.pluralsight.userinterface;

import com.pluralsight.models.*;
import java.util.*;

public class UserInterface {

    //
    private Scanner scanner;
    private Order currentOrder;

    //
    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.currentOrder = null;
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
        boolean ordering = true;
        while (ordering) {
            int choice = showOrderMenu();
            switch (choice) {
                case 1 -> addingSandwich();
                case 2 -> addingDrink();
                case 3 -> addingChips();
                case 4 -> { checkingOut(); ordering = false; }
                case 0 -> { System.out.println("Order Cancelled.");
                            currentOrder = null;
                            ordering = false; }
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

    //
    private void addingSandwich() {
        System.out.println("\n=== Make Your Sandwich ===");
        //
        String breadType = whatBreadType();
        int size = whatSize();
        boolean isToasted = toastedOrNot();
        Sandwich sandwich = new Sandwich(size, breadType, isToasted);
        //
        whatMeats().forEach(sandwich::addMeat);
        whatCheeses().forEach(sandwich::addCheese);
        whatRegularToppings().forEach(sandwich::addRegularTopping);
        whatSauces().forEach(sandwich::addSauce);
        //
        currentOrder.addSandwich(sandwich);
        System.out.println("\nSandwich added to order!");
        System.out.println(sandwich.getSummary());
    }

    //
    private String whatBreadType() {
        while (true) {
            System.out.println("\nWhat bread type would you like?:");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");
            System.out.print("Select an option (1-4): ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: return "White";
                    case 2: return "Wheat";
                    case 3: return "Rye";
                    case 4: return "Wrap";
                    default:
                        System.out.println("Invalid input! Please try again.");
                }
            } else {
                System.out.println("Invalid input (not a number)! Please try again.");
                scanner.nextLine();
            }
        }
    }

    //
    private int whatSize() {
        while (true) {
            System.out.println("\nWhat bread size would you like?");
            System.out.println("4 Inches");
            System.out.println("8 Inches");
            System.out.println("12 Inches");
            System.out.print("Select an option (4, 8, 12): ");
            int size = scanner.nextInt();
            scanner.nextLine();
            if (size == 4 || size == 8 || size == 12)
                return size;
            else
                System.out.println("Invalid input! Please try again.");
        }
    }

    //
    private boolean toastedOrNot() {
        while (true) {
            System.out.print("\nWould you like the sandwich toasted? (Yes/No): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes") || response.equals("y"))
                return true;
            else if (response.equals("no") || response.equals("n"))
                return false;
            else
                System.out.println("Invalid input! Please try again.");
        }
    }

    //
    private List<Topping> whatMeats() {
        List<Topping> meats = new ArrayList<>();
        System.out.println("\n=== Add Meats ===");
        System.out.println("\nAvailable meat:\nSteak\nHam Salami\nRoast Beef\nChicken\nBacon");
        System.out.println("\nType the meat name or 'done' to finish.");
        //
        while (true) {
            System.out.print("Add meat: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("done")) break;
            Topping meat = getMeatName(input);
            if (meat != null) {
                System.out.print("Is this extra meat? (yes/no): ");
                String extraInput = scanner.nextLine().trim().toLowerCase();
                boolean isExtra = extraInput.equals("yes") || extraInput.equals("y");
                meats.add(Topping.getInstance(meat, isExtra));
                System.out.println(meat.getName() + " added" + (isExtra ? " (Extra)" : ""));
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
        return meats;
    }

    //
    private List<Topping> whatCheeses() {
        List<Topping> cheeses = new ArrayList<>();
        System.out.println("\n=== Add Cheeses ===");
        System.out.println("\nAvailable cheese:\nAmerican\nProvolone\nRoast Beef\nCheddar\nSwiss");
        System.out.println("\nType the cheese name or 'done' to finish.");
        //
        while (true) {
            System.out.print("Add cheese: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("done")) break;
            Topping cheese = getCheeseName(input);
            if (cheese != null) {
                System.out.print("Is this extra cheese? (yes/no): ");
                String extraInput = scanner.nextLine().trim().toLowerCase();
                boolean isExtra = extraInput.equals("yes") || extraInput.equals("y");
                cheeses.add(Topping.getInstance(cheese, isExtra));
                System.out.println(cheese.getName() + " added" + (isExtra ? " (Extra)" : ""));
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
        return cheeses;
    }

    //
    private List<Topping> whatRegularToppings() {
        List<Topping> toppings = new ArrayList<>();
        System.out.println("\n=== Add Regular Toppings ===");
        System.out.println("\nAvailable regular toppings: " +
                "\nLettuce, Peppers, Onions,\nTomatoes, Jalapeños, Cucumbers,\nPickles, Guacamole, Mushrooms");
        System.out.println("\nType the topping name or 'done' to finish.");
        //
        while (true) {
            System.out.print("Add topping: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("done")) break;
            Topping topping = getRegularToppingName(input);
            if (topping != null) {
                toppings.add(topping);
                System.out.println(topping.getName() + " added");
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
        return toppings;
    }

    //
    private List<Topping> whatSauces() {
        List<Topping> sauces = new ArrayList<>();
        System.out.println("\n=== Add Sauces & Sides ===");
        System.out.println("\nAvailable: \nMayo, Mustard, Ketchup,\nRanch, Thousand Islands, Vinaigrette");
        System.out.println("\nSides: \nAu Jus, Extra Sauce");
        System.out.println("\nType sauce name or 'done' to finish:");
        //
        while (true) {
            System.out.print("Add sauce/sides: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("done")) break;
            Topping sauce = getSauceName(input);
            if (sauce != null) {
                sauces.add(sauce);
                System.out.println(sauce.getName() + " added");
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
        return sauces;
    }

    //

}