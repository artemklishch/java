package org.example.model;

import java.util.List;

public class OrderProxy extends Order {
    private List<Product> products = null;
    boolean isSessionOpen = false;

    @Override
    public List<Product> getProducts() {
        if (products != null) {
            return products;
        }
        if (isSessionOpen) {
            products = initProducts();
            return products;
        }
        throw new LayerInstantiationException("Can't initialize collection products - no Session");
    }

    private List<Product> initProducts() {
        return null;
    }
}
