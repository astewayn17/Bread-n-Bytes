package com.pluralsight.models.signatures;

import com.pluralsight.models.*;

public class BLT extends Sandwich {

    // Constructor that sets up a new signature sandwich object with pre-assigned ingredients
    public BLT() {
        super(8, "White", false);
        setToasted(true);
        addMeat(Topping.bacon);
        addCheese(Topping.cheddar);
        addRegularTopping(Topping.lettuce);
        addRegularTopping(Topping.tomatoes);
        addSauce(Topping.ranch);
    }

    // Will show up in the User Interface as the signature sandwich name above the info when selected
    @Override
    public String toString() { return "BLT Sandwich:"; }
}