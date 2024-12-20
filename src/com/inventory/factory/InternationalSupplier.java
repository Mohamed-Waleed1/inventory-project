/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.factory;

/**
 *
 * @author mohamedwaleed
 */    
public class InternationalSupplier extends Supplier {
    public InternationalSupplier(String supplierId, String name) {
        super(supplierId, name);
    }

    @Override
    public void displayDetails() {
        System.out.println("International Supplier: " + getName() + ", ID: " + getSupplierId());
    }
}

    

