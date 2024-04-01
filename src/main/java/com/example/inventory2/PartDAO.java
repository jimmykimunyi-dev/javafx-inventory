package com.example.inventory2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartDAO {
    public void save(Part part) {
        String sql = "INSERT INTO parts (id, name, inv, cost, max, min, machineid) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, part.getId());
            statement.setString(2, part.getName());
            statement.setInt(3, part.getInventory()); // Use getInventory() here
            statement.setDouble(4, part.getCost());
            statement.setInt(5, part.getMax());
            statement.setInt(6, part.getMin());
            statement.setInt(7, part.getMachineId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}