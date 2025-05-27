package com.pluralsight.userinterface;

import com.pluralsight.models.*;
import com.pluralsight.utilities.ReceiptWriter;

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
                    default: System.out.println("Invalid input! Please try again.");
                }
            } else {
                System.out.println("Invalid input! Please try again.");
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
                System.out.print("Is this extra meat? (Yes/No): ");
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
                System.out.print("Is this extra cheese? (Yes/No): ");
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
        System.out.println("\nType the sauce name or 'done' to finish:");
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
    private void addingDrink() {
        System.out.println("\n=== Add Drink ===");
        //
        String[] flavors = { "Coke", "Diet Coke", "Sprite", "Root Beer", "Dr Pepper", "Mountain Dew",
                "Ginger Ale", "Iced Tea", "Fruit Punch", "Celsius", "Sparkling Water", "Water" };
        int flavorChoice;
        String flavor;
        while (true) {
            System.out.println("\nAvailable Flavors:");
            for (int i = 0; i < flavors.length; i++) {
                System.out.printf("%d) %s%n", i + 1, flavors[i]);
            }
            System.out.print("Select an option (1–12): ");
            if (scanner.hasNextInt()) {
                flavorChoice = scanner.nextInt();
                scanner.nextLine();
                if (flavorChoice >= 1 && flavorChoice <= flavors.length) {
                    flavor = flavors[flavorChoice - 1];
                    break;
                } else {
                    System.out.println("Invalid input! Please try again.");
                }
            } else {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine();
            }
        }
        //
        String size;
        while (true) {
            System.out.println("\nSelect size:");
            System.out.println("1) Small - $2.00");
            System.out.println("2) Medium - $2.50");
            System.out.println("3) Large - $3.00");
            System.out.print("Select an option (1–3): ");
            if (scanner.hasNextInt()) {
                int sizeChoice = scanner.nextInt();
                scanner.nextLine();
                switch (sizeChoice) {
                    case 1 -> size = "Small";
                    case 2 -> size = "Medium";
                    case 3 -> size = "Large";
                    default -> { System.out.println("Invalid input! Please try again.");
                        continue; }
                } break;
            } else {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine();
            }
        }
        //
        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);
        System.out.println("\n" + drink.getSummary() + "added to order!");
    }

    //
    private void addingChips() {
        System.out.println("\n=== Add Chips ===");
        //
        String[] chipOptions = { "Classic Lay's", "BBQ Lay's", "Doritos Nacho Cheese", "Doritos Cool Ranch",
                "Cheetos", "Ruffles Cheddar & Sour Cream", "SunChips", "Salt & Vinegar", "Jalapeño Chips" };
        for (int i = 0; i < chipOptions.length; i++) {
            System.out.printf("%d) %s%n", i + 1, chipOptions[i]);
        }
        String type;
        while (true) {
            System.out.print("Select an option (1–9): ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= chipOptions.length) {
                    type = chipOptions[choice - 1];
                    break;
                } else {
                    System.out.println("Invalid input! Please try again.");
                }
            } else {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine();
            }
        }
        //
        Chips chips = new Chips(type);
        currentOrder.addChips(chips);
        System.out.println("\n" + chips.getSummary() + "added to order!");
    }

    //
    private void checkingOut() {
        if (currentOrder.isEmpty()) {
            System.out.println("\nNothing in your order.");
            return;
        }
        System.out.println("\n" + currentOrder.getOrderSummary());
        String confirm;
        while (true) {
            System.out.print("Confirm order? (Yes/No): ");
            confirm = scanner.nextLine().trim().toLowerCase();
            if (confirm.equals("yes") || confirm.equals("y") || confirm.equals("no") || confirm.equals("n")) {
                break;
            }
            System.out.println("Invalid input! Please try again.");
        }
        if (confirm.equals("yes") || confirm.equals("y")) {
            ReceiptWriter.saveReceipt(currentOrder);
            System.out.println("\nOrder confirmed! Receipt saved.");
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Order cancelled.");
        }
        currentOrder = null;
    }

    //

}