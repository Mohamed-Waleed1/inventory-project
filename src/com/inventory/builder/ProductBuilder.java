/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.builder;

/**
 *
 * @author mohamedwaleed
 */
import com.inventory.factory.Product;
import com.inventory.factory.ProductFactory;

public class ProductBuilder {
    private String type;
    private String productId;
    private String name;
    private double price;

    public ProductBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return ProductFactory.createProduct(type, productId, name, price);
    }
}

