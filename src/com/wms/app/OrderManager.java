package com.wms.app;

import com.wms.model.Item;
import com.wms.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    //method to find the order
    public Order findOrder(int order)
    {
        for (Order currentOrder : orders)
        {
            if (currentOrder.getOrderId() == order)
            {
                return currentOrder;
            }
        }
        return null;
    }

    //to update the order
    public void updateOrder (int orderId, Item item)
    {
        Order order = findOrder(orderId);
        if (order != null)
        {
            order.addItem(item);
        }
    }

    //to delete order
    public void deleteOrder (int orderId)
    {
        Order order = findOrder(orderId);
        if(order != null)
        {
           orders.remove(order);
    }
    }

    //To get all order
    public List<Order> getAllOrders()
    {
        return orders;
    }


    @Override
    public String toString() {
        return "Order in Manager: " + orders;

    }
}
