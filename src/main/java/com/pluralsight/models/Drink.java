package com.pluralsight.models;

public class Drink {

    //
    private String size;
    private String flavor;
    private double price;

    //
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = priceForSize();
    }

    //
    private double priceForSize() {

    }

    //
    public String getSummary() {
        return String.format("%s %s - $%.2f", size, flavor, price);
    }

    //
    public String getSize() { return size; }
    public String getFlavor() { return flavor; }
    public double getPrice() { return price; }
}
