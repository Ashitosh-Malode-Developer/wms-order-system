package com.wms.app;

import com.wms.model.Item;
import com.wms.model.Order;
import com.wms.model.OrderStatus;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderManager {

    private List<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    //method to find the order
    public Order findOrder(int orderId) {

        String sql =
                "SELECT o.order_id, o.status, i.item_id, i.item_name, oi.quantity " +
                        "FROM orders o " +
                        "JOIN order_items oi ON o.order_id = oi.order_id " +
                        "JOIN items i ON oi.item_id = i.item_id " +
                        "WHERE o.order_id = ?";

        Order order = null;

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                if (order == null) {
                    order = new Order(
                            resultSet.getInt("order_id")
                    );

                    order.setStatus(
                            OrderStatus.valueOf(resultSet.getString("status"))
                    );
                }

                Item item = new Item(
                        resultSet.getInt("item_id"),
                        resultSet.getString("item_name"),
                        resultSet.getInt("quantity")
                );

                order.addItem(item);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
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
//    public void deleteOrder (int orderId)
//    {
//        Order order = findOrder(orderId);
//        if(order != null)
//        {
//           orders.remove(order);
//    }
//    }

    //To get all order
    public List<Order> getAllOrders()
    {
        return orders;
    }


    @Override
    public String toString() {
        return "Order in Manager: " + orders;

    }

    //DB connection and order create in DB method
    public void createOrder(Order order) {

        String orderSql = "INSERT INTO orders (order_id, status) VALUES (?, ?)";
        String itemSql = "INSERT INTO order_items (order_id, item_id, quantity) VALUES (?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();

            connection.setAutoCommit(false);

            PreparedStatement orderStatement = connection.prepareStatement(orderSql);
            orderStatement.setInt(1, order.getOrderId());
            orderStatement.setString(2, order.getStatus().name());
            orderStatement.executeUpdate();

            PreparedStatement itemStatement = connection.prepareStatement(itemSql);

            for (Item item : order.getItems()) {
                itemStatement.setInt(1, order.getOrderId());
                itemStatement.setInt(2, item.getItemId());
                itemStatement.setInt(3, item.getQuantity());
                itemStatement.executeUpdate();
            }

            connection.commit();
            connection.close();

            System.out.println("Order created successfully!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // to add an item to existing order
    public void addItemToOrder(int orderId, Item item) {

        String sql = "INSERT INTO order_items(order_id, item_id, quantity) VALUES(?,?,?)";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, orderId);
            statement.setInt(2, item.getItemId());
            statement.setInt(3, item.getQuantity());

            statement.executeUpdate();

            connection.close();

            System.out.println("Item added to Order!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // To update order status
    public void updateOrderStatus(int orderId, String status) {

        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, status);
            statement.setInt(2, orderId);

            statement.executeUpdate();

            connection.close();

            System.out.println("Order status updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // To Delete an order
    public void deleteOrder(int orderId) {

        String deleteItemsSql =
                "DELETE FROM order_items WHERE order_id = ?";

        String deleteOrderSql =
                "DELETE FROM orders WHERE order_id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            // Start transaction
            connection.setAutoCommit(false);

            PreparedStatement deleteItems =
                    connection.prepareStatement(deleteItemsSql);

            deleteItems.setInt(1, orderId);
            deleteItems.executeUpdate();

            PreparedStatement deleteOrder =
                    connection.prepareStatement(deleteOrderSql);

            deleteOrder.setInt(1, orderId);
            deleteOrder.executeUpdate();

            // Save both changes
            connection.commit();

            connection.close();

            System.out.println("Order deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
