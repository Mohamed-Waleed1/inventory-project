/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.factory;

/**
 *
 * @author mohamedwaleed
 */
public class LocalSupplier extends Supplier {
    public LocalSupplier(String supplierId, String name) {
        super(supplierId, name);
    }

    @Override
    public void displayDetails() {
        System.out.println("Local Supplier: " + getName() + ", ID: " + getSupplierId());
    }
}

    

