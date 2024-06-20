module javafx.javafx_image_to_ascii {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires net.synedra.validatorfx;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.bootstrapfx.core;
  requires java.desktop;

  opens javafx to javafx.fxml;
  exports javafx;
  exports controllers;
  opens controllers to javafx.fxml;
}