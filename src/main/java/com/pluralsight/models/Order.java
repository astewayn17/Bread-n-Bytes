package com.pluralsight.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Order {

    // Declaring all the necessary variables that define an order. Food are lists because the user can order multiple
    private String orderNumber;
    private LocalDateTime orderDateTime;
    private List<Sandwich> sandwiches;
    private List<Drinks> drinks;
    private List<Chips> chips;

    // Declaring these separately and static because they should just be used class wide not based on individual objects
    private static int orderCounter = 0;
    private static double taxRate = 0.0825;

    // Constructor with no parameters since the user won't need to pass anything into it. Will record the current time,
    // the order number will go up every time the user makes a new order and the food are array list types
    public Order() {
        orderNumber = "ORDER NUMBER - " + (++orderCounter); //
        orderDateTime = LocalDateTime.now();
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    // Methods to add foods to their lists/cart
    public void addSandwich(Sandwich sandwich) { sandwiches.add(sandwich); }
    public void addDrink(Drinks drink) { drinks.add(drink); }
    public void addChips(Chips chips) { this.chips.add(chips); }

    // Method to calculate the subtotal price. Uses the stream method on each type of food list that acquires the price
    // of each one and adds them together.
    public double getSubTotalPrice() {
        return sandwiches.stream().mapToDouble(Sandwich::getPrice).sum()
                + drinks.stream().mapToDouble(Drinks::getPrice).sum()
                + chips.stream().mapToDouble(Chips::getPrice).sum();
    }

    // Used to get the complete total price by adding the necessary tax based on the tax rate
    public double getTotalPrice() { return getSubTotalPrice() * (1 + taxRate); }

    // This is used to display the order summary to the user
    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("**** ORDER SUMMARY ****");
        sb.append("Order Number: " + orderNumber);
        sb.append("\nOrder Date: " + orderDateTime);
        // If statement that lists a food type if it is present using the string builder. It goes through the respective
        // lists and with IntStream.range, it makes a stream of integers from 0 to however many foods there are. The
        // line below that maps each integer index into a string and gets the summary of that food. Then it collects the
        // formatted strings into a single string that is accurately displayed.
        if (!sandwiches.isEmpty()) {
            sb.append("\n\nSANDWICHES: \n");
            sb.append(IntStream.range(0, sandwiches.size())
                    .mapToObj(i -> String.format("%d. %s", i + 1, sandwiches.get(i).getSummary()))
                    .collect(Collectors.joining("\n")));
        } if (!drinks.isEmpty()) {
            sb.append("\n\nDRINKS: \n");
            sb.append(IntStream.range(0, drinks.size())
                    .mapToObj(i -> String.format("%d. %s", i + 1, drinks.get(i).getSummary()))
                    .collect(Collectors.joining("\n")));
        } if (!chips.isEmpty()) {
            sb.append("\n\nCHIPS: \n");
            sb.append(IntStream.range(0, chips.size())
                    .mapToObj(i -> String.format("%d. %s", i + 1, chips.get(i).getSummary()))
                    .collect(Collectors.joining("\n")));
        }
        // Displays the formatted info for the totals and tax and returns all the info using the toString method
        sb.append("\n\n").append("=".repeat(30)).append("\n");
        sb.append(String.format("SUB TOTAL: $%.2f\n", getSubTotalPrice()));
        sb.append(String.format("TAXABLE: $%.2f\n", getSubTotalPrice()));
        sb.append(String.format("TAX: $%.2f\n", taxRate * getSubTotalPrice()));
        sb.append(String.format("TOTAL: $%.2f\n", getTotalPrice()));
        sb.append("=".repeat(30)).append("\n");
        return sb.toString();
    }

    // Method to remove the items from the list/cart
//    public void clear() {
//        sandwiches.clear();
//        drinks.clear();
//        chips.clear();
//        orderDateTime = LocalDateTime.now();
//    }

    // Used to check if the order has anything in the lists/cart
//    public boolean isEmpty() {
//        return sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty();
//    }

    // Standard getters for the declared variable
    public String getOrderNumber() { return orderNumber; }
    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public List<Sandwich> getSandwiches() { return sandwiches; }
    public List<Drinks> getDrinks() { return drinks; }
    public List<Chips> getChips() { return chips; }
}
