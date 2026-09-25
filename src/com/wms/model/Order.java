package com.wms.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

public class Order {

   @Min(1)
    private int orderId;
    @Valid
    private List<Item> items;
    private OrderStatus status;

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    public Order(int orderId)
    {
        this.orderId= orderId;
        this.items= new ArrayList<>();
        this.status=OrderStatus.CREATED;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return items;
    }


    public OrderStatus getStatus()
    {
        return status;
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
        return "Order ID: " + orderId +
                " Status: " + status +
                " Items: " + items;
    }
}
