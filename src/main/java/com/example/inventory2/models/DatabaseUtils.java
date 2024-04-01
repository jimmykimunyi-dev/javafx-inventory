package com.example.inventory2.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static DatabaseUtils instance;
    private Connection connection;

    private DatabaseUtils() {
        connection = DatabaseConnection.getConnection();
    }

    public static DatabaseUtils getInstance() {
        if (instance == null) {
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public List<Part> getAllParts() {
        List<Part> partsList = new ArrayList<>();
        String query = "SELECT * FROM parts";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int inventory = resultSet.getInt("inv");
                double cost = resultSet.getDouble("cost");
                int max = resultSet.getInt("max");
                int min = resultSet.getInt("min");
                int machineId = resultSet.getInt("machineid");

                Part part = new Part(id, name, inventory, cost, max, min, machineId);
                partsList.add(part);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return partsList;
    }

    public List<Product> getAllProducts() {
        List<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM product";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int inventory = resultSet.getInt("inv");
                int cost = (int) resultSet.getDouble("cost");
                int max = resultSet.getInt("max");
                int min = resultSet.getInt("min");

                Product product = new Product(id, name, inventory, cost, max, min);
                productsList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productsList;
    }
}