package com.example.inventory2.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    public void save(Product product) {
        String sql = "INSERT INTO product (id, name, inv, cost, max, min) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getInventory()); // Use getInventory() here
            statement.setInt(4, product.getCost());
            statement.setInt(5, product.getMax());
            statement.setInt(6, product.getMin());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}