package com.pluralsight.utilities;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    //
    public static void saveReceipt(Order order) {
        try {
            //
            DateTimeFormatter fileNameFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            //
            FileWriter fileWriteBoi = new FileWriter("src/main/resources/receipts/"
                    + LocalDateTime.now().format(fileNameFormatter) + ".txt");
            BufferedWriter buffWriteBoi = new BufferedWriter(fileWriteBoi);
            buffWriteBoi.write(receiptFormatter(order));
            buffWriteBoi.close();
        } catch (IOException e) {
            System.err.println("Error! Could not write to file: " + e.getMessage());
        }
    }

    //
    public static String receiptFormatter(Order order) {

    }
}
