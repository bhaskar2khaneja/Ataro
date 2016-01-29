package mule.views;

import javafx.stage.Stage;
import mule.presenters.NameConfigPresenter;

public class RaceConfigController extends ArrowConfigView {
  public RaceConfigController(Stage stage) {
    super(stage);
  }

  @Override
  public void moveArrowUp() {
    grid.setRowIndex(arrow, ((grid.getRowIndex(arrow) - 1 ) % 8 + 8) % 8);
  }

  @Override
  public void moveArrowDown() {
    grid.setRowIndex(arrow, (grid.getRowIndex(arrow) + 1) % 8);
  }

  /**
   * TODO document
   */
  public void goToNameConfigScreen() {
    NameConfigController view = new NameConfigController(stage);
    NameConfigPresenter presenter = new NameConfigPresenter(view);
    setScene(view, "/fxml/NameConfig.fxml");
  }
}
