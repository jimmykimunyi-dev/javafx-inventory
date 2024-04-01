package com.example.inventory2.controllers;

import com.example.inventory2.Product;
import com.example.inventory2.ProductDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductFormController {

    private ProductDAO productDAO;

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @FXML
    private Button btnadd;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnremove;

    @FXML
    private Button btnsave;

    @FXML
    private TableColumn<?, ?> colcost;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colid2;

    @FXML
    private TableColumn<?, ?> colinv;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colname2;

    @FXML
    private TableColumn<?, ?> colprice;

    @FXML
    private TextField tfcost;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfinv;

    @FXML
    private TextField tfmax;

    @FXML
    private TextField tfmin;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfsearch;

    @FXML
    private TableView<?> tvinv;

    @FXML
    private TableView<?> tvinv2;

    @FXML
    private void handleCancelButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = loader.load();
            Scene mainMenuScene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(mainMenuScene);
            stage.show();
        } catch (Exception e) {
            showErrorDialog("Error loading MainMenu.fxml: " + e.getMessage());
        }
    }

    @FXML
    private void handleSaveButtonClick(ActionEvent event) {
        try {
            int id = parseIntegerOrThrow(tfid.getText(), "Invalid ID");
            String name = tfname.getText();
            int inventory = parseIntegerOrThrow(tfinv.getText(), "Invalid Inventory");
            int cost = (int) parseDoubleOrThrow(tfcost.getText(), "Invalid Cost");
            int max = parseIntegerOrThrow(tfmax.getText(), "Invalid Max");
            int min = parseIntegerOrThrow(tfmin.getText(), "Invalid Min");

            if (name.isEmpty()) {
                showErrorDialog("Name cannot be empty");
                return;
            }

            Product product = new Product(id, name, inventory, cost, max, min);

            productDAO.save(product);

            // Ensure that productDAO is not null
//            if (productDAO != null) {
//                // Save the product
//                productDAO.save(product);
//
//                // Show success message or perform any other actions upon successful save
//                System.out.println("Product saved successfully!");
//            } else {
//                // Handle the case when productDAO is not properly initialized
//                showErrorDialog("ProductDAO is not properly initialized.");
//            }
        } catch (NumberFormatException e) {
//            showErrorDialog(e.getMessage());
            e.printStackTrace();
        }

    }


    private int parseIntegerOrThrow(String value, String errorMessage) throws NumberFormatException {
        if (value.isEmpty()) {
            throw new NumberFormatException(errorMessage);
        }
        return Integer.parseInt(value);
    }

    private double parseDoubleOrThrow(String value, String errorMessage) throws NumberFormatException {
        if (value.isEmpty()) {
            throw new NumberFormatException(errorMessage);
        }
        return Double.parseDouble(value);
    }

    private void showErrorDialog(String message) {
        // Show an error dialog or handle the error in an appropriate way
        System.out.println("Error: " + message);
    }

}
