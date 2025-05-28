package com.pluralsight.models.signatures;

import com.pluralsight.models.*;

public class TexMexWrap extends Sandwich {

    // Constructor that sets up a new signature sandwich object with pre-assigned ingredients
    public TexMexWrap() {
        super(8, "Wrap", false);
        setToasted(false);
        addMeat(Topping.chicken);
        addCheese(Topping.cheddar);
        addRegularTopping(Topping.jalapenos);
        addRegularTopping(Topping.peppers);
        addRegularTopping(Topping.onions);
        addRegularTopping(Topping.guacamole);
        addSauce(Topping.ranch);
        addSauce(Topping.sauce);
    }

    // Will show up in the User Interface as the signature sandwich name above the info when selected
    @Override
    public String toString() { return "Tex-Mex Wrap Sandwich:"; }
}