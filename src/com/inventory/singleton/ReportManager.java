/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.singleton;

/**
 *
 * @author mohamedwaleed
 */
import java.util.Map;

public class ReportManager {
    private static ReportManager instance;

    private ReportManager() {}

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    public void generateReport(Map<String, Integer> stock, Map<String, String> productDetails) {
        // Start Debugging

        if (stock == null || stock.isEmpty()) {
            System.out.println("No stock data available to generate the report.");
            return;
        }

        // Generate the report
        System.out.println("\n--- Inventory Report ---");
        System.out.printf("%-15s %-20s %-10s\n", "Product ID", "Product Name", "Stock");
        System.out.println("-------------------------------------------");
        for (String productId : stock.keySet()) {
            String productName = productDetails.getOrDefault(productId, "Unknown Product");
            int quantity = stock.get(productId);
            System.out.printf("%-15s %-20s %-10d\n", productId, productName, quantity);
        }
        System.out.println("-------------------------------------------");
    }
}
