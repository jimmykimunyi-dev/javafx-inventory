package com.example.inventory2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {

    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private Button home;

    public void switchToMainMenu(ActionEvent event) throws IOException {

        // Initialize the PartDAO
        PartDAO partDAO = new PartDAO();

        // Initialize the ProductDAO
        ProductDAO productDAO = new ProductDAO();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            MainMenuController controller = loader.getController();
            controller.setPartDAO(partDAO);
            controller.setProductDAO(productDAO);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
