package mule.views;

import javafx.stage.Stage;
import mule.models.ConfigurationModel;
import mule.presenters.ColorConfigPresenter;

public class DifficultyConfigController extends ArrowConfigView {
  public DifficultyConfigController(Stage stage) {
    super(stage);
  }

  @Override
  public void moveArrowUp() {
    grid.setRowIndex(arrow, ((grid.getRowIndex(arrow) - 1 ) % 3 + 3) % 3);
  }

  @Override
  public void moveArrowDown() {
    grid.setRowIndex(arrow, (grid.getRowIndex(arrow) + 1) % 3);
  }

  /**
   * Goes to the next screen, the configuration screen to select the player
   * colors.
   */
  public void goToColorConfigController(ConfigurationModel model) {
    ColorConfigController view = new ColorConfigController(stage);
    ColorConfigPresenter presenter = new ColorConfigPresenter(view, model);
    setScene(view, "/fxml/ColorConfig.fxml");
  }
}
