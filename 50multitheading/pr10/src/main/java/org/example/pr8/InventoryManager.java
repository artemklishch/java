package org.example.pr8;

public class InventoryManager {
    private int stockCount;

    public InventoryManager(int stockCount) {
        this.stockCount = stockCount;
    }

    public synchronized boolean placeOrder(int orderQuantity) {
        if (stockCount >= orderQuantity) {
            stockCount -= orderQuantity;
            return true;
        }
        return false;
    }
}
