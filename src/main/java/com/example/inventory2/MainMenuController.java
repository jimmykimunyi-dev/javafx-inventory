package com.example.inventory2;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class MainMenuController {

    private PartDAO partDAO;

    public void setPartDAO(PartDAO partDAO) {
        this.partDAO = partDAO;
    }
    public ObservableList<Part> getPartsList() {
        return partsList;
    }

    public void setPartsList(ObservableList<Part> partsList) {
        this.partsList = partsList;
    }

    public ObservableList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ObservableList<Product> productsList) {
        this.productsList = productsList;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public Button getBtnadd() {
        return btnadd;
    }

    public void setBtnadd(Button btnadd) {
        this.btnadd = btnadd;
    }

    public Button getBtnadd2() {
        return btnadd2;
    }

    public void setBtnadd2(Button btnadd2) {
        this.btnadd2 = btnadd2;
    }

    public Button getBtndelete() {
        return btndelete;
    }

    public void setBtndelete(Button btndelete) {
        this.btndelete = btndelete;
    }

    public Button getBtndelete2() {
        return btndelete2;
    }

    public void setBtndelete2(Button btndelete2) {
        this.btndelete2 = btndelete2;
    }

    public Button getBtnmodify() {
        return btnmodify;
    }

    public void setBtnmodify(Button btnmodify) {
        this.btnmodify = btnmodify;
    }

    public Button getBtnmodify2() {
        return btnmodify2;
    }

    public void setBtnmodify2(Button btnmodify2) {
        this.btnmodify2 = btnmodify2;
    }

    public TableColumn<Part, Integer> getTcid1() {
        return tcid1;
    }

    public void setTcid1(TableColumn<Part, Integer> tcid1) {
        this.tcid1 = tcid1;
    }

    public TableColumn<Product, Integer> getTcid2() {
        return tcid2;
    }

    public void setTcid2(TableColumn<Product, Integer> tcid2) {
        this.tcid2 = tcid2;
    }

    public TableColumn<Part, Integer> getTcinv1() {
        return tcinv1;
    }

    public void setTcinv1(TableColumn<Part, Integer> tcinv1) {
        this.tcinv1 = tcinv1;
    }

    public TableColumn<Product, Integer> getTcinv2() {
        return tcinv2;
    }

    public void setTcinv2(TableColumn<Product, Integer> tcinv2) {
        this.tcinv2 = tcinv2;
    }

    public TableColumn<Part, String> getTcname1() {
        return tcname1;
    }

    public void setTcname1(TableColumn<Part, String> tcname1) {
        this.tcname1 = tcname1;
    }

    public TableColumn<Product, String> getTcname2() {
        return tcname2;
    }

    public void setTcname2(TableColumn<Product, String> tcname2) {
        this.tcname2 = tcname2;
    }

    public TableColumn<Part, Double> getTcprice1() {
        return tcprice1;
    }

    public void setTcprice1(TableColumn<Part, Double> tcprice1) {
        this.tcprice1 = tcprice1;
    }

    public TableColumn<?, ?> getTcprice2() {
        return tcprice2;
    }

    public void setTcprice2(TableColumn<Product, Double> tcprice2) {
        this.tcprice2 = tcprice2;
    }

    public TextField getTfsearch() {
        return tfsearch;
    }

    public void setTfsearch(TextField tfsearch) {
        this.tfsearch = tfsearch;
    }

    public TextField getTfsearch2() {
        return tfsearch2;
    }

    public void setTfsearch2(TextField tfsearch2) {
        this.tfsearch2 = tfsearch2;
    }

    public TableView<Part> getTvparts() {
        return tvparts;
    }

    public void setTvparts(TableView<Part> tvparts) {
        this.tvparts = tvparts;
    }

    public TableView<Product> getTvproducts() {
        return tvproducts;
    }

    public void setTvproducts(TableView<Product> tvproducts) {
        this.tvproducts = tvproducts;
    }

    private ObservableList<Part> partsList = FXCollections.observableArrayList();
    private ObservableList<Product> productsList = FXCollections.observableArrayList();

    private Stage stage;

    private Scene scene;

    private Parent root;


    public void switchToAddFormPart(ActionEvent event) throws  IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFormPart.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // Get the AddFormPartController and initialize the PartDAO
            AddFormPartController addFormPartController = loader.getController();
            addFormPartController.setPartDAO(new PartDAO());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToModifyFormPart(ActionEvent event) throws  IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPartForm.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // Get the ModifyFormPartController and initialize the PartDAO
            ModifyFormPartController modifyFormPartController = loader.getController();
            modifyFormPartController.setPartDAO(new PartDAO());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void switchToAddProductForm(ActionEvent event) throws  IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProductForm.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // Get the AddProductFormController and initialize the ProductDAO
            AddProductFormController addProductFormController = loader.getController();
            addProductFormController.setProductDAO(new ProductDAO());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void switchToModifyProductForm(ActionEvent event) throws  IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyProductForm.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            // Get the ModifyProductFormController and initialize the ProductDAO
            ModifyProductFormController modifyProductFormController = loader.getController();
            modifyProductFormController.setProductDAO(new ProductDAO());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void searchByName() {
        String searchTerm = tfsearch.getText();
        ObservableList<Part> filteredParts = FXCollections.observableArrayList();

        for (Part part : DatabaseUtils.getInstance().getAllParts()) {
            if (part.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                filteredParts.add(part);
            }
        }

        tvparts.setItems(filteredParts);
    }


    @FXML
    public void exit(){
        Platform.exit();
    }

    @FXML
    private Button btnadd;

    @FXML
    private Button btnadd2;

    @FXML
    private Button btndelete;

    @FXML
    private Button btndelete2;

    @FXML
    private Button btnmodify;

    @FXML
    private Button btnmodify2;

    @FXML
    private TableColumn<Part, Integer> tcid1;

    @FXML
    private TableColumn<Part, String> tcname1;

    @FXML
    private TableColumn<Part, Integer> tcinv1;

    @FXML
    private TableColumn<Part, Double> tcprice1;

    @FXML
    private TableColumn<Product, Integer> tcid2;

    @FXML
    private TableColumn<Product, String> tcname2;

    @FXML
    private TableColumn<Product, Integer> tcinv2;

    @FXML
    private TableColumn<Product, Double> tcprice2;

    @FXML
    private TextField tfsearch;

    @FXML
    private TextField tfsearch2;

    @FXML
    private TableView<Part> tvparts;

    @FXML
    private TableView<Product> tvproducts;

    @FXML
    private void initialize() {
        // Load data from the database
        loadPartsData();
        loadProductsData();

        // Set cell value factories for TableView columns
        tcid1.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        tcname1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tcinv1.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getInventory()).asObject());
        tcprice1.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getCost()).asObject());

        tcid2.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        tcname2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tcinv2.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getInventory()).asObject());
        tcprice2.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getCost()).asObject());

        // Set data to TableViews
        tvparts.setItems(partsList);
        tvproducts.setItems(productsList);
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
