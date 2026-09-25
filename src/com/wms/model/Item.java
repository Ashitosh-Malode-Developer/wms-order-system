package com.wms.model;
import jakarta.validation.constraints.Min;

public class Item {
    private String itemName;
    @Min(1)
    private int quantity;
    @Min(1)
    private int itemId;
    public Item(int itemId, String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemId = itemId;
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
    public int getItemId()
    {
        return itemId;
    }

    @Override
    public String toString() {
        return itemName + "(QTY: " + quantity + ")";
    }
}

