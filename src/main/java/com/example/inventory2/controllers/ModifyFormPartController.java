package com.example.inventory2.controllers;

import com.example.inventory2.Part;
import com.example.inventory2.PartDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyFormPartController {

    private PartDAO partDAO;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnsave;

    @FXML
    private RadioButton rdin;

    @FXML
    private RadioButton rdout;

    @FXML
    private TextField tfcost;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfinv;

    @FXML
    private TextField tfmachineid;

    @FXML
    private TextField tfmax;

    @FXML
    private TextField tfmin;

    @FXML
    private TextField tfname;

    public Button getBtncancel() {
        return btncancel;
    }

    public void setBtncancel(Button btncancel) {
        this.btncancel = btncancel;
    }

    public Button getBtnsave() {
        return btnsave;
    }

    public void setBtnsave(Button btnsave) {
        this.btnsave = btnsave;
    }

    public RadioButton getRdin() {
        return rdin;
    }

    public void setRdin(RadioButton rdin) {
        this.rdin = rdin;
    }

    public RadioButton getRdout() {
        return rdout;
    }

    public void setRdout(RadioButton rdout) {
        this.rdout = rdout;
    }

    public TextField getTfcost() {
        return tfcost;
    }

    public void setTfcost(TextField tfcost) {
        this.tfcost = tfcost;
    }

    public TextField getTfid() {
        return tfid;
    }

    public void setTfid(TextField tfid) {
        this.tfid = tfid;
    }

    public TextField getTfinv() {
        return tfinv;
    }

    public void setTfinv(TextField tfinv) {
        this.tfinv = tfinv;
    }

    public TextField getTfmachineid() {
        return tfmachineid;
    }

    public void setTfmachineid(TextField tfmachineid) {
        this.tfmachineid = tfmachineid;
    }

    public TextField getTfmax() {
        return tfmax;
    }

    public void setTfmax(TextField tfmax) {
        this.tfmax = tfmax;
    }

    public TextField getTfmin() {
        return tfmin;
    }

    public void setTfmin(TextField tfmin) {
        this.tfmin = tfmin;
    }

    public TextField getTfname() {
        return tfname;
    }

    public void setTfname(TextField tfname) {
        this.tfname = tfname;
    }


    @FXML
    private void handleCancelButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Scene mainMenuScene = new Scene(loader.load());

            Stage stage = (Stage) btncancel.getScene().getWindow();

            stage.setScene(mainMenuScene);
            stage.show();
        } catch (Exception e) {
            // Handle any exceptions that might occur during loading
            showErrorDialog("Error loading MainMenu.fxml: " + e.getMessage());
        }

    }

    @FXML
    private void handleSaveButtonClick(ActionEvent event) {
        try {
            int id = parseIntegerOrThrow(tfid.getText(), "Invalid ID");
            String name = tfname.getText();
            int inventory = parseIntegerOrThrow(tfinv.getText(), "Invalid Inventory");
            double cost = parseDoubleOrThrow(tfcost.getText(), "Invalid Cost");
            int max = parseIntegerOrThrow(tfmax.getText(), "Invalid Max");
            int min = parseIntegerOrThrow(tfmin.getText(), "Invalid Min");
            int machineId = parseIntegerOrThrow(tfmachineid.getText(), "Invalid Machine ID");

            if (name.isEmpty()) {
                showErrorDialog("Name cannot be empty");
                return;
            }

            Part part = new Part(id, name, inventory, cost, max, min, machineId);
            partDAO.save(part);
        } catch (NumberFormatException e) {
            showErrorDialog(e.getMessage());
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

    public void setPartDAO(PartDAO partDAO) {
        this.partDAO = partDAO;
    }


}
