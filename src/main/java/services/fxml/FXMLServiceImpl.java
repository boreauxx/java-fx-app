package services.fxml;

import javafx.MainApplication;
import javafx.StateManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLServiceImpl implements FXMLService {

  @Override
  public void setCustomScene(String resourceUrl, String title) throws IOException {
    FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(resourceUrl));
    Parent root = loader.load();
    Scene dashboard = new Scene(root, 1280, 720);
    Stage stage = StateManager.getPrimaryStage();
    stage.setTitle(title);
    stage.setScene(dashboard);
  }

  @Override
  public void setDashboardScene() throws IOException {
    setCustomScene("dashboard-view.fxml", "Dashboard");
  }

  @Override
  public void setMyFilesScene() throws IOException {
    setCustomScene("files-view.fxml", "Files");
  }
}
