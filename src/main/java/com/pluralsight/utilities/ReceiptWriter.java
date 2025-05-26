package com.pluralsight.utilities;

import com.pluralsight.models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class ReceiptWriter {

    // Method to make and save the receipts
    public static void saveReceipt(Order order) {
        try {
            // Formatting the date and time into this to use as the file name for the receipt
            DateTimeFormatter fileNameFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            // Makes the file and writes to it using the file writer and buffered writer
            FileWriter fileWriteBoi = new FileWriter("src/main/resources/receipts/"
                    + LocalDateTime.now().format(fileNameFormatter) + ".txt");
            BufferedWriter buffWriteBoi = new BufferedWriter(fileWriteBoi);
            buffWriteBoi.write(receiptFormatter(order));
            buffWriteBoi.close();
        } catch (IOException e) {
            System.err.println("Error! Could not write to file: " + e.getMessage());
        }
    }

    // Formats the design of the receipt to be written
    public static String receiptFormatter(Order order) {
        // Heading/Top
        StringBuilder sb = new StringBuilder();
        sb.append("=".repeat(50)).append("\n");
        sb.append("               Bread 'n Bytes RECEIPT\n");
        sb.append("=".repeat(50)).append("\n\n");
        // Formats the date printed on the receipt and then the order details below it
        DateTimeFormatter fileNameFormatter2 = DateTimeFormatter.ofPattern("MM/dd/yy h:mm a");
        sb.append("Date: ").append(LocalDateTime.now().format(fileNameFormatter2)).append("\n\n");
        sb.append("ORDER DETAILS:\n");
        sb.append("-".repeat(50)).append("\n\n");
        // These are standard for each loops instead of streams so they can be easily formatted
        // Checks if the order has sandwiches first and then iterates through them while appending
        // each of them together and adding the number to each
        if (!order.getSandwiches().isEmpty()) {
            sb.append("SANDWICHES:\n");
            int sandwichNumber = 1;
            for (Sandwich sandwich : order.getSandwiches()) {
                sb.append("\n").append(sandwichNumber++).append(". ");
                sb.append(sandwichFormatter(sandwich));
            }
        } if (!order.getDrinks().isEmpty()) {
            sb.append("\nDRINKS:\n");
            int drinkNumber = 1;
            for (Drink drink : order.getDrinks()) {
                sb.append(drinkNumber++).append(". ");
                sb.append(drink.getSummary());
            }
        } if (!order.getChips().isEmpty()) {
            sb.append("\nCHIPS:\n");
            int chipsNumber = 1;
            for (Chips chips : order.getChips()) {
                sb.append(chipsNumber++).append(". ");
                sb.append(chips.getSummary());
            }
            sb.append("\n");
        }
        // The bottom of the receipt showing the charge and footer
        sb.append("-".repeat(50)).append("\n");
        sb.append(String.format("SUBTOTAL: $%.2f\n", order.getSubTotalPrice()));
        sb.append(String.format("TAXABLE: $%.2f\n", order.getSubTotalPrice()));
        sb.append(String.format("TAX (8.25%%): $%.2f\n", Order.getTaxRate() * order.getSubTotalPrice()));
        sb.append(String.format("TOTAL: $%.2f\n", order.getTotalPrice()));
        sb.append("=".repeat(50)).append("\n\n");
        sb.append("Thank you for choosing Bread 'n Bytes!\n");
        sb.append("Visit us again soon!\n");
        return sb.toString();
    }

    // Used to append to the receipt formatter
    private static String sandwichFormatter(Sandwich sandwich) {
        // Very similar to how the order is displayed
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d\" %s Sandwich", sandwich.getSize(), sandwich.getBreadType()));
        if (sandwich.isToasted()) {
            sb.append(" (Toasted)");
        }
        sb.append(String.format(" - $%.2f", sandwich.getMeatNCheesePrice()));
        // If there are any meats in the list, it will append the information and stream through the meat list and get
        // the name and use an internal ternary to write if the meat is extra or not and then it collects the strings
        // neatly displays them together. Same thing for the cheese and regular toppings.
        if (!sandwich.getMeats().isEmpty()) {
            sb.append("\n  Meats: ");
            sb.append(sandwich.getMeats().stream()
                    .map(meat -> meat.getName() + (meat.isExtra() ? " (Extra)" : ""))
                    .collect(Collectors.joining(", ")));
        } if (!sandwich.getCheeses().isEmpty()) {
            sb.append("\n  Cheeses: ");
            sb.append(sandwich.getCheeses().stream()
                    .map(cheese -> cheese.getName() + (cheese.isExtra() ? " (Extra)" : ""))
                    .collect(Collectors.joining(", ")));
        } if (!sandwich.getRegularToppings().isEmpty()) {
            sb.append("\n  Toppings: ");
            sb.append(sandwich.getRegularToppings().stream()
                    .map(Topping::getName)
                    .collect(Collectors.joining(", ")));
        } if (!sandwich.getSauces().isEmpty()) {
            sb.append("\n  Sauces: ");
            sb.append(sandwich.getSauces().stream()
                    .map(Topping::getName)
                    .collect(Collectors.joining(", ")));
        }
        return sb.toString();
    }
}