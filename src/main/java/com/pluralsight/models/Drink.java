package com.pluralsight.models;

public class Drink {

    // Declaring all the necessary variables that define a drink.
    private String size;
    private String flavor;
    private double price;

    // Constructor
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = priceForSize();
    }

    // Calculates the price for the drink price based on the size
    private double priceForSize() {
        return switch (this.size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> throw new IllegalArgumentException("Incorrect drink size: " + this.size);
        };
    }

    // Shows a simple summary that the order class uses to show it to the user
    public String getSummary() {
        return String.format("%s %s - $%.2f", this.size, this.flavor, this.price);
    }

    // Basic getters
    public String getSize() { return size; }
    public String getFlavor() { return flavor; }
    public double getPrice() { return price; }
}