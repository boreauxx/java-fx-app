package controllers;

import javafx.StateManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.fxml.FXMLService;
import services.fxml.FXMLServiceImpl;
import services.image.ImageService;
import services.image.ImageServiceImpl;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileController {

  @FXML
  public TextArea asciiOutputArea;

  private Stage primaryStage;
  private final ImageService imageService = new ImageServiceImpl();
  private final FXMLService fxmlService = new FXMLServiceImpl();

  public void initialize() {
    this.primaryStage = StateManager.getPrimaryStage();
    asciiOutputArea.setPrefHeight(40);
    asciiOutputArea.setPrefWidth(240);
    asciiOutputArea.setEditable(false);
    asciiOutputArea.setStyle("-fx-font-size: " + 24 + "px;");
  }

  @FXML
  protected void handleSwitchToDashboard() throws IOException {
    fxmlService.setDashboardScene();
  }

  @FXML
  protected void handleUploadButtonEvent() {
    FileChooser fileChooser = new FileChooser(); // EXP: Create file chooser
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG", "*.jpg"),
        new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG", "*.png"),
        new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF", "*.gif")
    );


    File file = fileChooser.showOpenDialog(primaryStage); // EXP: Open FileChooser and get the selected file

    if (file != null) {  // EXP: Check if file exists
      try {
        BufferedImage image = ImageIO.read(file);
        String asciiOutput = imageService.convertToASCII(image);
        imageService.saveToFile(asciiOutput, file.getParentFile());
        asciiOutputArea.setText("File's been converted and downloaded as ascii_art.txt in the same directory.");
      } catch (IOException exception) {
        System.out.println(exception.getMessage());
      }
    }
  }




}