package com.wms.model;

public class Item {
    private String itemName;
    private int quantity;

    public Item(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }

    @Override
    public String toString() {
        return itemName + "(QTY: " + quantity + ")";
    }
}

