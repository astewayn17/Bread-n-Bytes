package com.pluralsight.models;

// This enum makes more sense to use because it categorizes the toppings as constants and each topping is assigned one
// of these when they are created. I went with this over an interface because interfaces are meant to define behavior
// rather than categorize. Enums are also more safe since only the exact values can be used. I could use strings, but
// then it would lose type sensitivity and less professional. Enums are also simple to use in conditionals
public enum ToppingType {
    MEAT,
    CHEESE,
    REGULAR,
    SAUCE
}
