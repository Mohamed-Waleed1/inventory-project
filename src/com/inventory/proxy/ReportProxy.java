/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.proxy;

/**
 *
 * @author mohamedwaleed
 */
import com.inventory.singleton.ReportManager;
import com.inventory.singleton.StockManager;

import java.util.Map;

public class ReportProxy {
    private final boolean isAdmin;

    public ReportProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

   public void generateReport() {
    if (isAdmin) {
        ReportManager reportManager = ReportManager.getInstance();
        StockManager stockManager = StockManager.getInstance();
        Map<String, Integer> stockData = stockManager.getStockData();
        Map<String, String> productDetails = stockManager.getProductDetails();
        reportManager.generateReport(stockData, productDetails);
    } else {
        System.out.println("Access denied. Admin privileges required.");
    }
}


}
