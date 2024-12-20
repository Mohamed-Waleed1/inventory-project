/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.prototype;

/**
 *
 * @author mohamedwaleed
 */
import com.inventory.factory.Product;
import com.inventory.factory.ProductFactory;

public class ProductPrototype {
    public static Product cloneProduct(Product product) {
        return ProductFactory.createProduct(
            product.getClass().getSimpleName().toLowerCase(),
            product.getProductId(),
            product.getName(),
            product.getPrice()
        );
    }
}

    
