package javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import services.fxml.FXMLService;
import services.fxml.FXMLServiceImpl;

import java.io.IOException;

public class MainApplication extends Application {

  private final FXMLService fxmlService = new FXMLServiceImpl();

  @Override
  public void start(Stage stage) throws IOException {
    StateManager.setPrimaryStage(stage);

    fxmlService.setDashboardScene();

    stage.setResizable(false);
    stage.show();

  }

  public static void main(String[] args) {
    launch();
  }
}