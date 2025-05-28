package com.pluralsight.models;

import java.util.HashMap;
import java.util.Map;

public class Topping {

    // Declaring all the necessary variables that define a topping. The costPerSize is a map that stores Integer which
    // will be the sandwich size and Double which will be the cost of the topping based on the bread size.
    private String name;
    private ToppingType type;
    private Map<Integer, Double> costPerSize;
    private boolean isExtra;

    // Private constructor meant to have topping with a name, type (enum), and pricing for it based on size.
    private Topping(String name, ToppingType type, Map<Integer, Double> costPerSize) {
        this.name = name;
        this.type = type;
        this.costPerSize = costPerSize;
        this.isExtra = false;
    }

    // Makes and returns a hashmap of sandwich sizes to the topping cost.
    private static Map<Integer, Double> priceMap(double price4, double price8, double price12) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(4, price4);
        map.put(8, price8);
        map.put(12, price12);
        return map;
    }

    // Makes a new topping based on one that already exists and marks it as extra
    // without messing with the original topping object.
    public static Topping getInstance(Topping topping, boolean isExtra) {
        Topping newTopping = new Topping(topping.name, topping.type, topping.costPerSize);
        newTopping.isExtra = isExtra;
        return newTopping;
    }

    // Making meat (enum) topping objects using the private constructor and making them public to be used project wide,
    // static to belong to the class and not to any other instance and final to make them unchangeable.
    public static final Topping steak = new Topping ("Steak", ToppingType.MEAT, priceMap(1.00, 2.00, 3.00));
    public static final Topping ham = new Topping ("Ham", ToppingType.MEAT, priceMap(1.00, 2.00, 3.00));
    public static final Topping salami = new Topping ("Salami", ToppingType.MEAT, priceMap(1.00, 2.00, 3.00));
    public static final Topping roastBeef = new Topping ("Roast Beef", ToppingType.MEAT, priceMap(1.00, 2.00, 3.00));
    public static final Topping chicken = new Topping ("Chicken", ToppingType.MEAT, priceMap(1.00, 2.00, 3.00));
    public static final Topping bacon = new Topping ("Bacon", ToppingType.MEAT, priceMap(1.00, 2.00, 3.00));
    // Cheeses
    public static final Topping american = new Topping("American", ToppingType.CHEESE, priceMap(0.75, 1.50, 2.25));
    public static final Topping provolone = new Topping("Provolone", ToppingType.CHEESE, priceMap(0.75, 1.50, 2.25));
    public static final Topping cheddar = new Topping("Cheddar", ToppingType.CHEESE, priceMap(0.75, 1.50, 2.25));
    public static final Topping swiss = new Topping("Swiss", ToppingType.CHEESE, priceMap(0.75, 1.50, 2.25));
    // Regulars
    public static final Topping lettuce = new Topping("Lettuce", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping peppers = new Topping("Peppers", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping onions = new Topping("Onions", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping tomatoes = new Topping("Tomatoes", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping jalapenos = new Topping("Jalapeños", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping cucumbers = new Topping("Cucumbers", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping pickles = new Topping("Pickles", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping guacamole = new Topping("Guacamole", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    public static final Topping mushrooms = new Topping("Mushrooms", ToppingType.REGULAR, priceMap(0.00, 0.00, 0.00));
    // Sauces (no cost)
    public static final Topping mayo = new Topping("Mayo", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));
    public static final Topping mustard = new Topping("Mustard", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));
    public static final Topping ketchup = new Topping("Ketchup", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));
    public static final Topping ranch = new Topping("Ranch", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));
    public static final Topping thousandIsland = new Topping("Thousand Islands", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));
    public static final Topping vinaigrette = new Topping("Vinaigrette", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));
    // Sides (no cost)
    public static final Topping auJus = new Topping("Au Jus", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));
    public static final Topping sauce = new Topping("Sauce", ToppingType.SAUCE, priceMap(0.00, 0.00, 0.00));

    // Standard getters
    public String getName() { return name; }
    public ToppingType getType() { return type; }
    public boolean isExtra() { return isExtra; }
    // Returns the price of the topping based on its size and if the topping isn't in the map, it returns 0.
    public double getPrice(int size) { return costPerSize.getOrDefault(size, 0.0); }

    // Uses toString to return the topping's name
    @Override
    public String toString() { return name; }
}