package com.pluralsight.models;

public class Chips {

    // Declaring all the necessary variables that define chips.
    private String brand;
    private double price = 1.50;

    // Constructor
    public Chips(String brand) {
        this.brand = brand;
    }

    // Shows a simple summary that the order class uses to show it to the user
    public String getSummary() {
        return String.format("%s - $%.2f", this.brand, this.price);
    }

    // Standard getters
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
}