package com.pluralsight.models.signatures.secret;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

public class Cheesequake extends Sandwich {

    //
    public Cheesequake() {
        super(8, "Wheat", true);
        setToasted(true);
        addCheese(Topping.american);
        addCheese(Topping.provolone);
        addCheese(Topping.american);
        addCheese(Topping.cheddar);
        addRegularTopping(Topping.peppers);
        addRegularTopping(Topping.onions);
        addSauce(Topping.sauce);
    }
}