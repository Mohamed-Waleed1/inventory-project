/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.gui;

/**
 *
 * @author mohamedwaleed
 */
import com.inventory.builder.ProductBuilder;
import com.inventory.factory.Product;
import com.inventory.proxy.ReportProxy;
import com.inventory.singleton.StockManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagementGUI {
    private final StockManager stockManager;

    public InventoryManagementGUI() {
        stockManager = StockManager.getInstance();
        new HashMap<>();
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Inventory Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Inventory Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addProductButton = new JButton("Add Product");
        JButton addStockButton = new JButton("Add Stock");
        JButton viewStockButton = new JButton("View Stock");
        JButton generateReportButton = new JButton("Generate Report");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(addProductButton);
        buttonPanel.add(addStockButton);
        buttonPanel.add(viewStockButton);
        buttonPanel.add(generateReportButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Action listeners
        addProductButton.addActionListener(e -> addProduct());
        addStockButton.addActionListener(e -> addStock());
        viewStockButton.addActionListener(e -> viewStock());
        generateReportButton.addActionListener(e -> generateReport());
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private void addProduct() {
    JTextField idField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField typeField = new JTextField();
    JTextField priceField = new JTextField();

    Object[] fields = {
            "Product ID:", idField,
            "Product Name:", nameField,
            "Product Type ( electronics, furniture):", typeField,
            "Product Price:", priceField
    };

    int result = JOptionPane.showConfirmDialog(null, fields, "Add Product", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
        try {
            String id = idField.getText();
            String name = nameField.getText();
            String type = typeField.getText();
            double price = Double.parseDouble(priceField.getText());

            // Create product (optional for Builder use)
            Product product = new ProductBuilder()
                    .setProductId(id)
                    .setName(name)
                    .setType(type)
                    .setPrice(price)
                    .build();

            // Add product details to StockManager
            stockManager.addProductDetails(id, name);

            JOptionPane.showMessageDialog(null, "Product added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}

 
    private void addStock() {
        JTextField idField = new JTextField();
        JTextField quantityField = new JTextField();

        Object[] fields = {
                "Product ID:", idField,
                "Stock Quantity:", quantityField
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Add Stock", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText();
                int quantity = Integer.parseInt(quantityField.getText());

                stockManager.addStock(id, quantity);
                JOptionPane.showMessageDialog(null, "Stock added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    private void viewStock() {
    Map<String, Integer> stockData = stockManager.getStockData();
    Map<String, String> productDetails = stockManager.getProductDetails();

    if (stockData.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No stock available to display.");
        return;
    }

    StringBuilder stockDisplay = new StringBuilder();
    stockDisplay.append(String.format("%-15s %-20s %-10s\n", "Product ID", "Product Name", "Stock"));
    stockDisplay.append("--------------------------------------------------------\n");

    for (String productId : stockData.keySet()) {
        String productName = productDetails.getOrDefault(productId, "Unknown Product");
        int stock = stockData.get(productId);
        stockDisplay.append(String.format("%-15s %-20s %-10d\n", productId, productName, stock));
    }

    JTextArea textArea = new JTextArea(stockDisplay.toString());
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);

    JOptionPane.showMessageDialog(null, scrollPane, "Stock Details", JOptionPane.INFORMATION_MESSAGE);
}

 

    private void generateReport() {
    JTextField adminField = new JTextField();

    Object[] fields = {
        "Are you an admin? ", adminField
    };

    int result = JOptionPane.showConfirmDialog(null, fields, "Generate Report", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
        try {
            boolean isAdmin = Boolean.parseBoolean(adminField.getText());
            ReportProxy proxy = new ReportProxy(isAdmin);

            if (isAdmin) {
                // Only call the proxy's generateReport method
                proxy.generateReport();
            } else {
                JOptionPane.showMessageDialog(null, "Access denied.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}



    public static void main(String[] args) {
        new InventoryManagementGUI();
    }
}
