package mule.views;

import javafx.stage.Stage;
import mule.models.ConfigurationModel;
import mule.presenters.DifficultyConfigPresenter;

public class NumOfPlayersConfigController extends ArrowConfigView {
  public NumOfPlayersConfigController(Stage stage) {
    super(stage);
  }

  @Override
  public void moveArrowUp() {
    grid.setRowIndex(arrow, ((grid.getRowIndex(arrow) - 1) % 4 + 4) % 4);
  }

  @Override
  public void moveArrowDown() {
    grid.setRowIndex(arrow, (grid.getRowIndex(arrow) + 1) % 4);
  }

  /**
   * Goes to the next screen, the configuration screen to select the difficulty.
   */
  public void goToDifficultyConfig(ConfigurationModel model) {
    DifficultyConfigController view = new DifficultyConfigController(stage);
    DifficultyConfigPresenter presenter = new DifficultyConfigPresenter(view, model);
    setScene(view, "/fxml/DifficultyConfig.fxml");
  }
}
