package com.pluralsight.models.signatures;

import com.pluralsight.models.*;

public class VeggieCrunch extends Sandwich {

    // Constructor that sets up a new signature sandwich object with pre-assigned ingredients
    public VeggieCrunch() {
        super(8, "Wheat", false);
        setToasted(false);
        addCheese(Topping.provolone);
        addRegularTopping(Topping.lettuce);
        addRegularTopping(Topping.tomatoes);
        addRegularTopping(Topping.cucumbers);
        addRegularTopping(Topping.pickles);
        addRegularTopping(Topping.peppers);
        addRegularTopping(Topping.onions);
        addSauce(Topping.vinaigrette);
    }

    // Will show up in the User Interface as the signature sandwich name above the info when selected
    @Override
    public String toString() { return "Veggie Crunch Sandwich:"; }
}