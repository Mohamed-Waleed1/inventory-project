/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.factory;

/**
 *
 * @author mohamedwaleed
 */
public class ProductFactory {
    public static Product createProduct(String type, String productId, String name, double price) {
        switch (type.toLowerCase()) {
            case "electronics" -> {
                return new Electronics(productId, name, price);
            }
            case "furniture" -> {
                return new Furniture(productId, name, price);
            }
            default -> throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}




    

