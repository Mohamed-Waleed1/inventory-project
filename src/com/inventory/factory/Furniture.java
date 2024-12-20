/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.factory;

/**
 *
 * @author mohamedwaleed
 */    
public class Furniture extends Product {
    public Furniture(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture Product: " + getName() +
                ", ID: " + getProductId() + ", Price: $" + getPrice());
    }
}


    

