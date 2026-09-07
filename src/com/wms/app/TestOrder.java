package com.wms.app;

import com.wms.model.Item;
import com.wms.model.Order;

import java.util.List;

public class TestOrder {
    public static void main(String[] args) {

        Item myItem = new Item("Laptop",2);
        Item myItem2 = new Item("Charger",2);
        Order myOrder = new Order(1001);
        Order myOrder2 = new Order(1002);

        // change item quantity
        myItem2.setQuantity(100);
        System.out.println(myItem2);

        //getter method to get item name
        //System.out.println(myItem.getItemName()); // print just item

        //add item to order
        myOrder.addItem(myItem);
        myOrder2.addItem(myItem2);
        System.out.println(myOrder2); //print order

        //add each order to OrderManager class for better management
        OrderManager manager = new OrderManager();
        manager.addOrder(myOrder);
        manager.addOrder(myOrder2);
        //System.out.println(manager);

        //to find order
        Order foundorder = manager.findOrder(1002);
        if(foundorder != null)
        {
            //System.out.println("Find Order is: " + foundorder);
        }
        else {
            //System.out.println("Order not found");
        }

        //to update order with item
        manager.updateOrder(1001, new Item("Mouse",1));
        //System.out.println(myOrder);

        //to remove order
//        manager.deleteOrder(1001);
//            System.out.println(manager);

        // Get all Orders
        List<Order> allOrders = manager.getAllOrders();
        //System.out.println(allOrders);

        //remove item
        myOrder.removeItem(myItem);
        //System.out.println(myOrder);
    }
    }


