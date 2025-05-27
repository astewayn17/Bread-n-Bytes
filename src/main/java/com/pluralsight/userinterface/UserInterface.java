package com.pluralsight.userinterface;

import com.pluralsight.models.*;
import com.pluralsight.utilities.ReceiptWriter;

import java.util.*;

public class UserInterface {

    // Declaring the scanner and the current order variables
    private Scanner scanner;
    private Order currentOrder;

    // Constructor
    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.currentOrder = null;
    }

    // Run method that will be used in the main method to control the initial screen
    public void run() {
        boolean running = true;
        while (running) {
            int choice = showHomeScreen();
            switch (choice) {
                case 1 -> startNewOrder();
                case 0 -> running = false;
                default -> System.out.println("\n❌ Invalid input! Please try again.");
            }
        }
    }

    // Home screen that is used in the run method and validates the user's input and returns the choice
    private int showHomeScreen() {
        while (true) {
            System.out.println("===\uD83C\uDF5E Bread 'n Bytes Home \uD83E\uDD6A===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Select an option (1 or 0): ");
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Invalid input! Please enter 1 or 0.\n");
            }
        }
    }

    // Starts a new order and shows the order menu after selected from the run method. Gives the user options for what
    // option they choose and runs those methods for what they want to order.
    private void startNewOrder() {
        currentOrder = new Order();
        boolean ordering = true;
        while (ordering) {
            int choice = showOrderMenu();
            switch (choice) {
                case 1 -> addingSandwich();
                case 2 -> addingDrink();
                case 3 -> addingChips();
                case 4 -> { checkingOut(); ordering = false; }
                case 0 -> { System.out.println("\n❌ Order Cancelled.\n");
                            currentOrder = null;
                            ordering = false; }
                default -> System.out.println("\n❌ Invalid input! Please try again.");
            }
        }
    }

    // This is what is shown to the user that start new order method controls
    private int showOrderMenu() {
        while (true) {
            System.out.println("\n======== Order  Menu ========");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option (0–4): ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Invalid input! Please enter a number from 0 - 4.");
            }
        }
    }

    // Method that adds the sandwich. Begins with the bread type method, sandwich size method, meats, cheese, toasted
    // or not, toppings and sauces and adds that sandwich to the current order. Uses simplified foreach loops to add the
    // chosen parts of the sandwich from the methods and adds them to the sandwich object.
    private void addingSandwich() {
        System.out.println("\n======= Add  Sandwich =======");
        String breadType = whatBreadType();
        int size = whatSize();
        Sandwich sandwich = new Sandwich(size, breadType);
        whatMeats().forEach(sandwich::addMeat);
        whatCheeses().forEach(sandwich::addCheese);
        boolean isToasted = toastedOrNot();
        sandwich.setToasted(isToasted);
        whatRegularToppings().forEach(sandwich::addRegularTopping);
        whatSauces().forEach(sandwich::addSauce);
        currentOrder.addSandwich(sandwich);
        System.out.println("\n✅ Sandwich added to order!\n--------------------------");
        System.out.println(sandwich.getSummary());
    }

    // Prompts the user for the bread type and validates that with a try catch included
    private String whatBreadType() {
        while (true) {
            System.out.println("What type of bread would you like?");
            System.out.println("1 - White");
            System.out.println("2 - Wheat");
            System.out.println("3 - Rye");
            System.out.println("4 - Wrap");
            System.out.print("Select an option (1-4): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("\n❌ Invalid input, cannot be empty! Please try again.\n");
                continue;
            }
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1: return "White";
                    case 2: return "Wheat";
                    case 3: return "Rye";
                    case 4: return "Wrap";
                    default: System.out.println("\n❌ Invalid input! Please enter a number from 1 - 4.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Invalid input! Please enter a number from 1 - 4.\n");
            }
        }
    }

    // Prompts the user for the size of the sandwich bread and validates
    private int whatSize() {
        while (true) {
            System.out.println("\nWhat bread size would you like?");
            System.out.println("4 Inches");
            System.out.println("8 Inches");
            System.out.println("12 Inches");
            System.out.print("Select an option (4,8,12): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("\nInput cannot be empty! Please try again.");
                continue;
            }
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 4: return 4;
                    case 8: return 8;
                    case 12: return 12;
                    default: System.out.println("\n❌ Invalid input! Please enter a number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Invalid input! Please enter a number.");
            }
        }
    }

    // Prompts the user if they want their sandwich toasted or not using if conditionals and or's
    private boolean toastedOrNot() {
        while (true) {
            System.out.print("\nWould you like the sandwich toasted? (Yes/No): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes") || response.equals("y"))
                return true;
            else if (response.equals("no") || response.equals("n"))
                return false;
            else
                System.out.println("\n❌ Invalid input! Please enter 'Yes' or 'No'.");
        }
    }

    // Used to prompt the user on what meats they would like to select
    private List<Topping> whatMeats() {
        List<Topping> meats = new ArrayList<>();
        System.out.println("\n========= Add Meats =========");
        System.out.println("1 - Steak\n2 - Ham\n3 - Salami\n4 - Roast Beef\n5 - Chicken\n6 - Bacon");
        System.out.println("\nSelect an option 1 - 6 or 'x' to finish.");
        // Loop that will manually record meat as extra if it is more than one.
        int meatCount = 0;
        while (true) {
            System.out.print("Add meat: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("x")) break;
            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 6) {
                    System.out.println("❌ Invalid input! Please enter a number from 1 - 6.");
                    continue;
                }
                // The choice is the user entered meat number and that gets mapped to the corresponding index on the
                // meatNames array. Then getMeatName is used to return a meat object based with a name and price.
                String[] meatNames = {"steak", "ham", "salami", "roast beef", "chicken", "bacon"};
                String selectedMeat = meatNames[choice - 1];
                Topping meat = getMeatName(selectedMeat);
                if (meat != null) {
                    boolean isExtra = (meatCount > 0);
                    // getInstance is called to make an object copy of the meat and label it as extra
                    meats.add(Topping.getInstance(meat, isExtra));
                    System.out.println(meat.getName() + " added" + (isExtra ? " (Extra)" : ""));
                    meatCount++;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number or 'x' to finish.");
            }
        }
        return meats;
    }

    // Prompts the user for the cheese they would like and automatically considers any more than one as extra.
    // Similar to the whatMeats method
    private List<Topping> whatCheeses() {
        List<Topping> cheeses = new ArrayList<>();
        System.out.println("\n======== Add Cheeses ========");
        System.out.println("1 - American\n2 - Provolone\n3 - Cheddar\n4 - Swiss");
        System.out.println("\nSelect an option 1 - 4 or 'x' to finish.");
        int cheeseCount = 0;
        while (true) {
            System.out.print("Add cheese: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("x")) break;
            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 4) {
                    System.out.println("❌ Invalid input! Please enter a number from 1 - 4.");
                    continue;
                }
                String[] cheeseNames = {"american", "provolone", "cheddar", "swiss"};
                String selectedCheese = cheeseNames[choice - 1];
                Topping cheese = getCheeseName(selectedCheese);
                if (cheese != null) {
                    boolean isExtra = (cheeseCount > 0); // First cheese is regular
                    cheeses.add(Topping.getInstance(cheese, isExtra));
                    System.out.println(cheese.getName() + " added" + (isExtra ? " (Extra)" : ""));
                    cheeseCount++;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number or 'x' to finish.");
            }
        }
        return cheeses;
    }

    // Prompts the user for what regular toppings that they would like and runs them through a loop that returns topping
    // Similar to whatMeats method
    private List<Topping> whatRegularToppings() {
        List<Topping> toppings = new ArrayList<>();
        System.out.println("\n=== Add Regular Toppings ===");
        System.out.println("1 - Lettuce\n2 - Peppers\n3 - Onions\n4 - Tomatoes\n5 - Jalapeños" +
                "\n6 - Cucumbers\n7 - Pickles\n8 - Guacamole\n9 - Mushrooms");
        System.out.println("\nSelect an option 1 - 9 or 'x' to finish.");
        while (true) {
            System.out.print("Add topping: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("x")) break;
            try {
                int choice = Integer.parseInt(input);
                String toppingName = null;
                switch (choice) {
                    case 1: toppingName = "lettuce"; break;
                    case 2: toppingName = "peppers"; break;
                    case 3: toppingName = "onions"; break;
                    case 4: toppingName = "tomatoes"; break;
                    case 5: toppingName = "jalapeños"; break;
                    case 6: toppingName = "cucumbers"; break;
                    case 7: toppingName = "pickles"; break;
                    case 8: toppingName = "guacamole"; break;
                    case 9: toppingName = "mushrooms"; break;
                    default: System.out.println("❌ Invalid input! Please enter a number from 1 - 9."); continue;
                }
                Topping topping = getRegularToppingName(toppingName);
                if (topping != null) {
                    toppings.add(topping);
                    System.out.println(topping.getName() + " added");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number or 'x' to finish.");
            }
        }
        return toppings;
    }

    // Prompts the user for what sauces/sides they want. Similar to whatRegularToppings method
    private List<Topping> whatSauces() {
        List<Topping> sauces = new ArrayList<>();
        System.out.println("\n==== Add Sauces & Sides ====");
        System.out.println("1 - Mayo\n2 - Mustard\n3 - Ketchup\n4 - Ranch");
        System.out.println("5 - Thousand Islands\n6 - Vinaigrette\n7 - Au Jus (Side)\n8 - Sauce (Side)");
        System.out.println("\nSelect an option 1 - 8 or 'x' to finish:");
        while (true) {
            System.out.print("Add sauce/sides: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("x")) break;
            try {
                int choice = Integer.parseInt(input);
                String sauceName = switch (choice) {
                    case 1 -> "mayo";
                    case 2 -> "mustard";
                    case 3 -> "ketchup";
                    case 4 -> "ranch";
                    case 5 -> "thousand islands";
                    case 6 -> "vinaigrette";
                    case 7 -> "au jus";
                    case 8 -> "sauce";
                    default -> null;
                };
                if (sauceName == null) {
                    System.out.println("❌ Invalid input! Please enter a number from 1 - 8.");
                    continue;
                }
                Topping sauce = getSauceName(sauceName);
                if (sauce != null) {
                    sauces.add(sauce);
                    System.out.println(sauce.getName() + " added");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number or 'x' to finish.");
            }
        }
        return sauces;
    }

    // Prompts the user for the drink and size they would like. Based on an array with numbers printed that the user
    // will have to choose that correspond to the index value in the array.
    private void addingDrink() {
        System.out.println("\n========= Add Drink =========");
        String[] flavors = {"Coke", "Diet Coke", "Sprite", "Root Beer", "Dr Pepper", "Mountain Dew",
                "Ginger Ale", "Iced Tea", "Fruit Punch", "Celsius", "Sparkling Water", "Water"};
        int flavorChoice;
        String flavor;
        while (true) {
            for (int i = 0; i < flavors.length; i++) {
                System.out.printf("%d - %s%n", i + 1, flavors[i]);
            }
            System.out.print("Select an option (1–12): ");
            if (scanner.hasNextInt()) {
                flavorChoice = scanner.nextInt();
                scanner.nextLine();
                if (flavorChoice >= 1 && flavorChoice <= flavors.length) {
                    flavor = flavors[flavorChoice - 1];
                    break;
                } else {
                    System.out.println("❌ Invalid input! Please enter a number from 1 - 12.");
                }
            } else {
                System.out.println("❌ Invalid input! Please enter a number from 1 - 12.");
                scanner.nextLine();
            }
        }
        String size;
        while (true) {
            System.out.println("\nWhat size would you like?");
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
                    default -> { System.out.println("❌ Invalid input! Please enter 1, 2, or 3.");
                        continue; }
                } break;
            } else {
                System.out.println("❌ Invalid input! Please enter a number from 1 - 3.");
                scanner.nextLine();
            }
        }
        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);
        System.out.println("\n" + drink.getSummary() + "\n✅ Added to order!");
    }

    // Prompts the user what chips they would like to add to the order. Similar to addingDrinks method without the size
    private void addingChips() {
        System.out.println("\n========= Add Chips =========");
        String[] chipOptions = {"Classic Lay's", "BBQ Lay's", "Doritos Nacho Cheese", "Doritos Cool Ranch",
                "Cheetos", "Ruffles Cheddar & Sour Cream", "SunChips", "Salt & Vinegar", "Jalapeño Chips"};
        for (int i = 0; i < chipOptions.length; i++) {
            System.out.printf("%d - %s%n", i + 1, chipOptions[i]);
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
                    System.out.println("❌ Invalid input! Please enter a number from 1 - 9.");
                }
            } else {
                System.out.println("❌ Invalid input! Please enter a number from 1 - 9.");
                scanner.nextLine();
            }
        }
        Chips chips = new Chips(type);
        currentOrder.addChips(chips);
        System.out.println("\n" + chips.getSummary() + "✅ Added to order!");
    }

    // Method to check out the order with confirmation and display it to the user and an option to cancel it instead.
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
            System.out.println("❌ Invalid input! Please enter 'Yes' or 'No'.");
        }
        if (confirm.equals("yes") || confirm.equals("y")) {
            ReceiptWriter.saveReceipt(currentOrder);
            System.out.println("\n✅ Order confirmed! Thank you!");
        } else {
            System.out.println("\n❌ Order cancelled.");
        }
        currentOrder = null;
    }

    // This is essentially a lookup function that returns the proper meat object from the topping class
    // that holds the prices too and is used to add to the sandwich object created when the user orders.
    private Topping getMeatName(String name) {
        return switch (name.toLowerCase()) {
            case "steak" -> Topping.steak;
            case "ham" -> Topping.ham;
            case "salami" -> Topping.salami;
            case "roast beef" -> Topping.roastBeef;
            case "chicken" -> Topping.chicken;
            case "bacon" -> Topping.bacon;
            default -> null;
        };
    }

    // Similar to getMeatName method
    private Topping getCheeseName(String name) {
        return switch (name.toLowerCase()) {
            case "american" -> Topping.american;
            case "provolone" -> Topping.provolone;
            case "cheddar" -> Topping.cheddar;
            case "swiss" -> Topping.swiss;
            default -> null;
        };
    }

    // Similar to getMeatName method
    private Topping getRegularToppingName(String name) {
        return switch (name.toLowerCase()) {
            case "lettuce" -> Topping.lettuce;
            case "peppers" -> Topping.peppers;
            case "onions" -> Topping.onions;
            case "tomatoes" -> Topping.tomatoes;
            case "jalapeños", "jalapenos" -> Topping.jalapenos;
            case "cucumbers" -> Topping.cucumbers;
            case "pickles" -> Topping.pickles;
            case "guacamole" -> Topping.guacamole;
            case "mushrooms" -> Topping.mushrooms;
            default -> null;
        };
    }

    // Similar to getMeatName method
    private Topping getSauceName(String name) {
        return switch (name.toLowerCase()) {
            case "mayo" -> Topping.mayo;
            case "mustard" -> Topping.mustard;
            case "ketchup" -> Topping.ketchup;
            case "ranch" -> Topping.ranch;
            case "thousand islands" -> Topping.thousand_islands;
            case "vinaigrette" -> Topping.vinaigrette;
            case "au jus" -> Topping.auJus;
            case "sauce" -> Topping.sauce;
            default -> null;
        };
    }
}