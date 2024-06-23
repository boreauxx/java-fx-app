package controllers;

import javafx.StateManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Product;
import services.fxml.FXMLService;
import services.fxml.FXMLServiceImpl;
import services.product.ProductService;
import services.product.ProductServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class ProductsController {
  @FXML
  protected TextField name;
  @FXML
  protected TextField portion;
  @FXML
  protected TextField price;
  @FXML
  protected TextField fats;
  @FXML
  protected TextField saturatedFats;
  @FXML
  protected TextField carbs;
  @FXML
  protected TextField sugar;
  @FXML
  protected TextField protein;
  @FXML
  protected TextField fiber;
  @FXML
  public Label validationLabel;
  @FXML
  protected Button addProductButton;

  private Stage primaryStage;
  private final FXMLService fxmlService = new FXMLServiceImpl();
  private final ProductService productService = new ProductServiceImpl();

  @FXML
  protected void initialize() throws IOException {
    this.primaryStage = StateManager.getPrimaryStage();
    List<TextField> textFields = List.of(name, portion, price, fats, saturatedFats, carbs, sugar, protein, fiber);

    for (TextField textField : textFields) {
      textField.textProperty().addListener((observable, oldValue, newValue) -> validateForm());
    }

    addProductButton.setDisable(true);
  }

  @FXML
  protected void handleSwitchToDashboard() throws IOException {
    fxmlService.setDashboardScene();
  }

  @FXML
  protected void handleAddProduct() {
    if(this.checkValues()){
      addProductButton.setDisable(false);
      try {
        Product product = createProduct();
        this.resetValues();
        validationLabel.setText("");
      }
      catch (Exception exception){
        validationLabel.setText("Please fill out all fields correctly.");
      }
    }
    else {
      validationLabel.setText("Please fill out all fields correctly.");
    }
  }

  private void validateForm() {
    if (checkValues()) {
      validationLabel.setText("");
      addProductButton.setDisable(false);
    } else {
      validationLabel.setText("All fields must be filled out.");
      addProductButton.setDisable(true);
    }
  }

  private boolean checkValues(){
    return !name.getText().isBlank() && !portion.getText().isBlank() && !price.getText().isBlank() &&
        !fats.getText().isBlank() && !saturatedFats.getText().isBlank() && !carbs.getText().isBlank() &&
        !sugar.getText().isBlank() && !protein.getText().isBlank() && !fiber.getText().isBlank();
  }

  private Product createProduct(){
    UUID _id = UUID.randomUUID();
    String _name = this.name.getText();
    int _portion = Integer.parseInt(this.portion.getText());
    double _price = Double.parseDouble(this.price.getText());
    double _fats = Double.parseDouble(this.fats.getText());
    double _saturatedFats = Double.parseDouble(this.saturatedFats.getText());
    double _carbs = Double.parseDouble(this.carbs.getText());
    double _sugar = Double.parseDouble(this.sugar.getText());
    double _protein = Double.parseDouble(this.protein.getText());
    double _fiber = Double.parseDouble(this.fiber.getText());
    return new Product(_id, _name, _portion, _price, _fats, _saturatedFats, _carbs, _sugar, _protein, _fiber);
  }

  private void resetValues(){
    this.name.setText("");
    this.portion.setText("");
    this.price.setText("");
    this.fats.setText("");
    this.saturatedFats.setText("");
    this.carbs.setText("");
    this.sugar.setText("");
    this.protein.setText("");
    this.fiber.setText("");
  }

}
