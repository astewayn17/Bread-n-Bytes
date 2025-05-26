package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    //
    private int size;
    private String breadType;
    private List<Topping> meats;
    private List<Topping> cheeses;
    private List<Topping> regularToppings;
    private List<Topping> sauces;
    private boolean isToasted;
    private double basePrice;

    //
    public Sandwich(int size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.isToasted = isToasted;
        this.basePrice = priceForSize();
    }

    //
    private double priceForSize() {
        return switch (this.size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> throw new IllegalArgumentException("Incorrect sandwich size: " + this.size);
        };
    }

    //
    public void addMeat(Topping meat) { meats.add(meat); }
    public void addCheese(Topping cheese) { cheeses.add(cheese); }
    public void addRegularTopping(Topping regularTopping) { regularToppings.add(regularTopping); }
    public void addSauce(Topping sauce) { sauces.add(sauce); }

}