package com.wms.model;

import java.util.List;
import java.util.ArrayList;

public class Order {

    private int orderId;
    private List<Item> items;

    public Order(int orderId)
    {
        this.orderId= orderId;
        this.items= new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public  void removeItem(Item item)
    {
        items.remove(item);
    }
    @Override
    public String toString() {
        return "Order ID: " + orderId + "Items : " + items;
    }
}
