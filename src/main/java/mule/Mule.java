package mule;

import javafx.application.Application;
import javafx.stage.Stage;
import mule.views.StartScreenController;
import mule.presenters.StartScreenPresenter;

public class Mule extends Application {
  @Override
  public void start(Stage stage) {
    StartScreenController view = new StartScreenController(stage);
    StartScreenPresenter presenter = new StartScreenPresenter(view);
    view.setScene(view, "/fxml/StartScreen.fxml");

    stage.setTitle("M.U.L.E.");
    stage.setResizable(false);

    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
