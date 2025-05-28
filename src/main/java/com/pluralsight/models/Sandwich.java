package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich {

    // Declaring all the necessary variables that define a sandwich. Toppings are lists since the user can order multiple
    private int size;
    private String breadType;
    private List<Topping> meats;
    private List<Topping> cheeses;
    private List<Topping> regularToppings;
    private List<Topping> sauces;
    private boolean isToasted;
    private double basePrice;

    // Constructor with three parameters that the user can enter for the sandwich specifically
    public Sandwich(int size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.isToasted = false;
        this.basePrice = priceForSize();
    }

    // Calculates the price for the base sandwich price based on the size
    private double priceForSize() {
        return switch (this.size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> throw new IllegalArgumentException("Incorrect sandwich size: " + this.size);
        };
    }

    // Methods to add meat, cheese, sauce, and regular toppings
    public void addMeat(Topping meat) { meats.add(meat); }
    public void addCheese(Topping cheese) { cheeses.add(cheese); }
    public void addRegularTopping(Topping regularTopping) { regularToppings.add(regularTopping); }
    public void addSauce(Topping sauce) { sauces.add(sauce); }

    // Calculates the total meat cost based on sandwich size. The first non-extra meat is charged its base price.
    // Any additional or explicitly extra meats are charged an extra fee based on size.
    private double calculateMeatCost() {
        double meatCost = 0.0;
        boolean hasRegularMeat = false;
        for (Topping meat : meats) {
            if (!meat.isExtra() && !hasRegularMeat) {
                hasRegularMeat = true;
                meatCost += meat.getPrice(size);
            } else {
                double extraCharge = switch (size) {
                    case 4 -> 0.50;
                    case 8 -> 1.00;
                    case 12 -> 1.50;
                    default -> throw new IllegalArgumentException("Incorrect sandwich size: " + size);
                };
                meatCost += extraCharge;
            }
        }
        return meatCost;
    }

    // Similar to the calculateMeatCost method
    private double calculateCheeseCost() {
        double cheeseCost = 0.0;
        boolean hasRegularCheese = false;

        for (Topping cheese : cheeses) {
            if (!cheese.isExtra() && !hasRegularCheese) {
                hasRegularCheese = true;
                cheeseCost += cheese.getPrice(size);
            } else {
                double extraCharge = switch (size) {
                    case 4 -> 0.30;
                    case 8 -> 0.60;
                    case 12 -> 0.90;
                    default -> throw new IllegalArgumentException("Incorrect sandwich size: " + size);
                };
                cheeseCost += extraCharge;
            }
        }
        return cheeseCost;
    }

    // Returns the complete cost of the base price, meats and cheeses.
    public double getMeatNCheesePrice() {
        return this.basePrice + calculateMeatCost() + calculateCheeseCost();
    }

    // Returns a sub summary of the sandwich used in the main order to show the user
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d\" %s Sandwich", this.size, this.breadType));
        if (isToasted) {
            sb.append(" (Toasted)");
        }
        // If there are any meats in the list, it will append the information and stream through the meat list and get
        // the name and use an internal ternary to write if the meat is extra or not and then it collects the strings
        // neatly displays them together. Same thing for the cheese and regular toppings.
        if (!meats.isEmpty()) {
            sb.append("\n   Meats: ");
            sb.append(meats.stream()
                    .map(meat -> meat.getName() + (meat.isExtra() ? " (Extra)" : ""))
                    .collect(Collectors.joining(", ")));
        } if (!cheeses.isEmpty()) {
            sb.append("\n   Cheeses: ");
            sb.append(cheeses.stream()
                    .map(cheese -> cheese.getName() + (cheese.isExtra() ? " (Extra)" : ""))
                    .collect(Collectors.joining(", ")));
        } if (!regularToppings.isEmpty()) {
            sb.append("\n   Toppings: ");
            sb.append(regularToppings.stream()
                    .map(Topping::getName)
                    .collect(Collectors.joining(", ")));
        } if (!sauces.isEmpty()) {
            sb.append("\n   Sauces: ");
            sb.append(sauces.stream()
                    .map(Topping::getName)
                    .collect(Collectors.joining(", ")));
        }
        sb.append(String.format("\n   Price: $%.2f", getMeatNCheesePrice()));
        return sb.toString();
    }

    // Standard getters and setter for the declared variables
    public int getSize() { return size; }
    public String getBreadType() { return breadType; }
    public List<Topping> getMeats() { return new ArrayList<>(meats); }
    public List<Topping> getCheeses() { return new ArrayList<>(cheeses); }
    public List<Topping> getRegularToppings() { return new ArrayList<>(regularToppings); }
    public List<Topping> getSauces() { return new ArrayList<>(sauces); }
    public boolean isToasted() { return isToasted; }
    public void setToasted(boolean toasted) { isToasted = toasted; }
}