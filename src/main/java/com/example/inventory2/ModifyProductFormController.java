package com.example.inventory2;

import com.example.inventory2.DatabaseUtils;
import com.example.inventory2.Part;
import com.example.inventory2.Product;
import com.example.inventory2.ProductDAO;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ModifyProductFormController {

    private ObservableList<Part> partsList = FXCollections.observableArrayList();
    private ObservableList<Product> productsList = FXCollections.observableArrayList();

    private ProductDAO productDAO;

    @FXML
    private Button btnadd;

    public Button getBtnadd() {
        return btnadd;
    }

    public void setBtnadd(Button btnadd) {
        this.btnadd = btnadd;
    }

    public Button getBtncancel() {
        return btncancel;
    }

    public void setBtncancel(Button btncancel) {
        this.btncancel = btncancel;
    }

    public Button getBtnremove() {
        return btnremove;
    }

    public void setBtnremove(Button btnremove) {
        this.btnremove = btnremove;
    }

    public Button getBtnsave() {
        return btnsave;
    }

    public void setBtnsave(Button btnsave) {
        this.btnsave = btnsave;
    }

    public Button getTfcancel() {
        return tfcancel;
    }

    public void setTfcancel(Button tfcancel) {
        this.tfcancel = tfcancel;
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

    public Button getTfsave() {
        return tfsave;
    }

    public void setTfsave(Button tfsave) {
        this.tfsave = tfsave;
    }

    public TextField getTfsearch() {
        return tfsearch;
    }

    public void setTfsearch(TextField tfsearch) {
        this.tfsearch = tfsearch;
    }

    public TableView<Part> getTv() {
        return tv;
    }

    public void setTv(TableView<Part> tv) {
        this.tv = tv;
    }

    public TableView<Product> getTv2() {
        return tv2;
    }

    public void setTv2(TableView<Product> tv2) {
        this.tv2 = tv2;
    }

    @FXML
    private Button btncancel;

    @FXML
    private Button btnremove;

    @FXML
    private Button btnsave;

    @FXML
    private Button tfcancel;

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
    private Button tfsave;

    @FXML
    private TextField tfsearch;

    @FXML
    private TableView<Part> tv;

    @FXML
    private TableView<Product> tv2;

    @FXML
    private TableColumn tcid;

    @FXML
    private TableColumn tcname;

    @FXML
    private TableColumn tcinv;

    @FXML
    private TableColumn tcprice;


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

            if (name.isEmpty()) {
                showErrorDialog("Name cannot be empty");
                return;
            }

            Product product = new Product(id, name, inventory, (int) cost, max, min);
            productDAO.save(product);
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

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @FXML
    private void initialize() {
        // Load data from the database
        loadPartsData();
        loadProductsData();

        // Set cell value factories for TableView columns
//        tcid.setCellValueFactory(new PropertyValueFactory<>("id"));
//        tcname.setCellValueFactory(new PropertyValueFactory<>("name"));
//        tcinv.setCellValueFactory(new PropertyValueFactory<>("inv"));
//        tcprice.setCellValueFactory(new PropertyValueFactory<>("cost"));


        // Set data to TableViews
        tv.setItems(partsList);
        tv2.setItems(productsList);
    }

    private void loadPartsData() {
        partsList.clear();
        partsList.addAll(DatabaseUtils.getInstance().getAllParts());
    }

    private void loadProductsData() {
        productsList.clear();
        productsList.addAll(DatabaseUtils.getInstance().getAllProducts());
    }
}
