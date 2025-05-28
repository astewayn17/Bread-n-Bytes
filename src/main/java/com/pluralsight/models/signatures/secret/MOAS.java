package com.pluralsight.models.signatures.secret;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

public class MOAS extends Sandwich {

    //
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
}