package com.pluralsight.models.signatures.secret;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

public class TheButchersSecret extends Sandwich {

    // Constructor that sets up a new secret signature sandwich object with pre-assigned ingredients and is set to true

    public TheButchersSecret() {
        super(12, "Rye", true);
        setToasted(false);
        addMeat(Topping.steak);
        addMeat(Topping.ham);
        addMeat(Topping.roastBeef);
        addMeat(Topping.chicken);
        addMeat(Topping.bacon);
        addCheese(Topping.american);
        addCheese(Topping.cheddar);
        addRegularTopping(Topping.onions);
        addSauce(Topping.mayo);
        addSauce(Topping.auJus);
    }
    // Will show up in the User Interface as the signature sandwich name above the info when selected
    @Override
    public String toString() { return "The Butcher's Secret Sandwich:"; }
}