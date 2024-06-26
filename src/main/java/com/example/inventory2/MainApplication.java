package com.example.inventory2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Initialize the PartDAO
        PartDAO partDAO = new PartDAO();

        // Initialize the ProductDAO
        ProductDAO productDAO = new ProductDAO();

        // Load the MainMenu.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
