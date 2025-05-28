package com.pluralsight;

import com.pluralsight.userinterface.UserInterface;

public class App {

    public static void main(String[] args) {
        // Opening Image
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║  Welcome to Bread 'n Bytes   ║");
        System.out.println("║  The CLI-ced Sandwich Shop   ║");
        System.out.println("╚══════════════════════════════╝");
        // Makes a new ui object from the UI class and
        // used to run the methods from the menus
        UserInterface ui = new UserInterface();
        ui.run();
        // Closing message
        System.out.println("\nThank you for visiting Bread 'n Bytes!");
    }
}
