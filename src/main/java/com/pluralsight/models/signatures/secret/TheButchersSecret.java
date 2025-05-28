package com.pluralsight.models.signatures.secret;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

public class TheButchersSecret extends Sandwich {

    //
    public TheButchersSecret() {
        super(12, "Rye", true);
        setToasted(false);
        addMeat(Topping.steak);
        addMeat(Topping.ham);
        addMeat(Topping.salami);
        addMeat(Topping.roastBeef);
        addMeat(Topping.chicken);
        addMeat(Topping.bacon);
        addCheese(Topping.american);
        addCheese(Topping.cheddar);
        addRegularTopping(Topping.onions);
        addSauce(Topping.mayo);
        addSauce(Topping.auJus);
    }
}