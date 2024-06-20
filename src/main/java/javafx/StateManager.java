package javafx;

import javafx.stage.Stage;

public class StateManager {

  private static Stage primaryStage;

  public static void setPrimaryStage(Stage stage) {
    primaryStage = stage;
  }

  public static Stage getPrimaryStage() {
    return primaryStage;
  }
}
