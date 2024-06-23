package controllers;

import javafx.StateManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import services.fxml.FXMLService;
import services.fxml.FXMLServiceImpl;

import java.io.IOException;

public class DashboardController {

  private Stage primaryStage;
  private final FXMLService fxmlService = new FXMLServiceImpl();

  public void initialize() {
    this.primaryStage = StateManager.getPrimaryStage();
  }

  @FXML
  protected void handleSwitchToMyFiles() throws IOException {
    fxmlService.setMyFilesScene();
  }

  @FXML
  public void handleSwitchToMyProducts() throws IOException {
    fxmlService.setMyProductsScene();
  }
}
