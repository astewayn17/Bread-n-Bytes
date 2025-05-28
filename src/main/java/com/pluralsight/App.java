package com.pluralsight;

import com.pluralsight.userinterface.UserInterface;

public class App {

    public static void main(String[] args) {
        // Makes a new ui object from the UI class and
        // used to run the methods from the menus
        UserInterface ui = new UserInterface();
        ui.run();
        // Closing message
        System.out.println("\nThank you for visiting Bread 'n Bytes!");
    }
}