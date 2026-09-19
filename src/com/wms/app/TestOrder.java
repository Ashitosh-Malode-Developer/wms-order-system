package com.wms.app;

import com.wms.model.Item;
import com.wms.model.Order;

public class TestOrder {
    public static void main(String[] args) {

//        Item myItem = new Item(1, "Laptop", 2);
//        Item myItem2 = new Item(2, "Charger", 2);
//        Order myOrder = new Order(1001);
//        Order myOrder2 = new Order(1002);

        OrderManager manager = new OrderManager();

        Order order1 = new Order(1001);
        manager.createOrder(order1);

        Item laptop = new Item(1, "Laptop", 2);
        manager.addItemToOrder(1001, laptop);
        Item charger = new Item(2,"Charger", 1);
        manager.addItemToOrder(1001, charger);

        Order order2 = new Order(1002);
        manager.createOrder(order2);

        Item mouse = new Item(3, "Mouse", 2);
        manager.addItemToOrder(1002, mouse);


        // change item quantity
        //myItem2.setQuantity(100);
        //System.out.println(myItem2);

        //getter method to get item name
        //System.out.println(myItem.getItemName()); // print just item

        //add item to order
        //myOrder.addItem(myItem);
        //myOrder2.addItem(myItem2);
        //System.out.println(myOrder2); //print order

        //add each order to OrderManager class for better management
        //OrderManager manager = new OrderManager();
        //manager.addOrder(myOrder);
        //manager.addOrder(myOrder2);
        //System.out.println(manager);

        //to find order
//        Order foundorder = manager.findOrder(1002);
//        if(foundorder != null)
//        {
//            System.out.println("Find Order is: " + foundorder);
//        }
//        else {
//            System.out.println("Order not found");
//        }

        //to update order with item
        //manager.updateOrder(1001, new Item("Mouse",1));
        //System.out.println(myOrder);

        //to remove order
//        manager.deleteOrder(1001);
//            System.out.println(manager);

        // Get all Orders
        //List<Order> allOrders = manager.getAllOrders();
        //System.out.println(allOrders);

        //remove item
        //myOrder.removeItem(myItem);
        //System.out.println(myOrder);

        //to view the status
        //System.out.println(myOrder2);
        //System.out.println(myOrder2.getStatus());

        //myOrder2.setStatus("Prcoessing");
        //System.out.println(myOrder2);

        // Create Order

        //create order and the item into a db
        //Order order = new Order(1002);
        //manager.createOrder(order);

        //Item item = new Item (3, "Mouse", 2);
        //manager.addItemToOrder(1002, item);

        //To update the order status
        //manager.updateOrderStatus(1002, "Processing");

        //To delete the order
        //manager.deleteOrder(1002);
    }
    }


