/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.singleton;

/**
 *
 * @author mohamedwaleed
 */   
import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private static StockManager instance;
    private final Map<String, Integer> stockData;
    private final Map<String, String> productDetails;

    private StockManager() {
        stockData = new HashMap<>();
        productDetails = new HashMap<>();
    }

    public static StockManager getInstance() {
        if (instance == null) {
            instance = new StockManager();
        }
        return instance;
    }

    public void addStock(String productId, int quantity) {
        stockData.put(productId, stockData.getOrDefault(productId, 0) + quantity);
    }

    public int getStock(String productId) {
        return stockData.getOrDefault(productId, 0);
    }

    public Map<String, Integer> getStockData() {
        return stockData;
    }

    public void addProductDetails(String productId, String productName) {
        productDetails.put(productId, productName);
    }

    public Map<String, String> getProductDetails() {
        return productDetails;
    }
}



