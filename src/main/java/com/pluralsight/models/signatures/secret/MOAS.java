package com.pluralsight.models.signatures.secret;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

public class MOAS extends Sandwich {

    // Constructor that sets up a new secret signature sandwich object with pre-assigned ingredients and is set to true
    public MOAS() {
        super(12, "White", true);
        setToasted(true);
        addMeat(Topping.steak);
        addMeat(Topping.chicken);
        addMeat(Topping.ham);
        addCheese(Topping.american);
        addCheese(Topping.provolone);
        addCheese(Topping.cheddar);
        addRegularTopping(Topping.lettuce);
        addRegularTopping(Topping.onions);
        addRegularTopping(Topping.tomatoes);
        addRegularTopping(Topping.pickles);
        addRegularTopping(Topping.guacamole);
        addSauce(Topping.mayo);
        addSauce(Topping.mustard);
        addSauce(Topping.sauce);
    }

    // Will show up in the User Interface as the signature sandwich name above the info when selected
    @Override
    public String toString() { return "Mother of all Sandwiches (MOAS):"; }
}