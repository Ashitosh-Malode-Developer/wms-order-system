package com.wms.app;

import com.wms.model.Item;
import com.wms.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {

    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(

                            "SELECT\n" +
                            "    o.order_id,\n" +
                            "    o.status,\n" +
                             "       i.itemId,\n"+
                            "    i.item_name,\n" +
                            "    oi.quantity\n" +
                            "FROM orders o\n" +
                            "JOIN order_items oi ON o.order_id = oi.order_id\n" +
                            "JOIN items i ON oi.item_id = i.item_id\n"
            );

            Order order = null;

            while (resultSet.next()) {

                int orderId = resultSet.getInt("order_id");
                String status = resultSet.getString("status");
                String itemName = resultSet.getString("item_name");
                int quantity = resultSet.getInt("quantity");
                int itemId = resultSet.getInt("itemId");

                if(order==null)
                {
                    order =new Order((orderId));
                    order.setStatus(status);
                }
                Item item = new Item(itemId, itemName, quantity);
                order.addItem(item);
                System.out.println(order);
                System.out.println(
                        "Order ID: " + orderId +
                                ", Status: " + status +
                                ", Item: " + itemName +
                                ", Quantity: " + quantity
                );
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}