/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.factory;

/**
 *
 * @author mohamedwaleed
 */
public class SupplierFactory {
    public static Supplier createSupplier(String type) {
        switch (type.toLowerCase()) {
            case "local":
                return new LocalSupplier("S001", "Local Supplies Co.");
            case "international":
                return new InternationalSupplier("S002", "Global Exports Inc.");
            default:
                throw new IllegalArgumentException("Unknown supplier type: " + type);
        }
    }
}




