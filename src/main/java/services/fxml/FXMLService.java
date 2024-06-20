package services.fxml;

import javafx.stage.Stage;

import java.io.IOException;

public interface FXMLService {

  void setCustomScene(String resourceUrl, String title) throws IOException;

  void setDashboardScene() throws IOException;

  void setMyFilesScene() throws IOException;
}
