package mule.views;

import javafx.stage.Stage;
import mule.models.ConfigurationModel;
import mule.views.ArrowConfigView;
import mule.presenters.RaceConfigPresenter;

public class ColorConfigController extends ArrowConfigView {
  public ColorConfigController(Stage stage) {
    super(stage);
  }

  @Override
  public void moveArrowUp() {
    grid.setRowIndex(arrow, ((grid.getRowIndex(arrow) - 1 ) % 4 + 4) % 4);
  }

  @Override
  public void moveArrowDown() {
    grid.setRowIndex(arrow, (grid.getRowIndex(arrow) + 1) % 4);
  }

  /**
   * TODO document
   */
  public void goToRaceConfigController(ConfigurationModel model) {
    RaceConfigController view = new RaceConfigController(stage);
    RaceConfigPresenter presenter = new RaceConfigPresenter(view, model);
    setScene(view, "/fxml/RaceConfig.fxml");
  }
}
