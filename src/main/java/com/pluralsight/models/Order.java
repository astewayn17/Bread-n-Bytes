package com.pluralsight.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    //
    private String orderNumber;
    private LocalDateTime orderDateTime;
    private List<Sandwich> sandwiches;
    private List<Drinks> drinks;
    private List<Chips> chips;

    //
    private static int orderCounter = 0;

    //
    public Order() {
        this.orderNumber = "ORDER NUMBER - " + (++orderCounter); //
        this.orderDateTime = LocalDateTime.now();
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    //
    public String getOrderNumber() { return orderNumber; }
    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public List<Sandwich> getSandwiches() { return sandwiches; }
    public List<Drinks> getDrinks() { return drinks; }
    public List<Chips> getChips() { return chips; }
}
