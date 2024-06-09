package org.example.model;

import java.util.List;
import java.util.Set;

public class OrderProxy extends Order {
    private Set<Product> products = null;
    boolean isSessionOpen = false;

    @Override
    public Set<Product> getProducts() {
        if (products != null) {
            return products;
        }
        if (isSessionOpen) {
            products = initProducts();
            return products;
        }
        throw new LayerInstantiationException("Can't initialize collection products - no Session");
    }

    private Set<Product> initProducts() {
        return null;
    }
}
