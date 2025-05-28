package com.pluralsight.models.signatures;

import com.pluralsight.models.*;

public class PhillyCheeseSteak extends Sandwich {

    // Constructor that sets up a new signature sandwich object with pre-assigned ingredients
    public PhillyCheeseSteak() {
        super(8, "White");
        setToasted(true);
        addMeat(Topping.steak);
        addCheese(Topping.american);
        addRegularTopping(Topping.peppers);
        addSauce(Topping.mayo);
    }

    // Will show up in the User Interface as the signature sandwich name above the info when selected
    @Override
    public String toString() { return "Philly Cheese Steak Sandwich:"; }
}