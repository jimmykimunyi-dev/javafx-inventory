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

    public void update(Part part) {
        String sql = "UPDATE parts SET name = ?, inv = ?, cost = ?, max = ?, min = ?, machineid = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, part.getName());
            statement.setInt(2, part.getInventory());
            statement.setDouble(3, part.getCost());
            statement.setInt(4, part.getMax());
            statement.setInt(5, part.getMin());
            statement.setInt(6, part.getMachineId());
            statement.setInt(7, part.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Part part) {
        String sql = "DELETE FROM parts WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, part.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}