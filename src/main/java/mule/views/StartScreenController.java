package mule.views;

import javafx.stage.Stage;
import mule.presenters.NumOfPlayersConfigPresenter;
import mule.models.ConfigurationModel;
import mule.models.Map;
import mule.presenters.MapViewPresenter;

public class StartScreenController extends View {
  public StartScreenController(Stage stage) {
    super(stage);
  }

  /**
   * Goes to the next screen, the configuration screen to select the number of
   * players.
   */
  public void goToNumOfPlayersConfig() {
    NumOfPlayersConfigController view = new NumOfPlayersConfigController(stage);
    NumOfPlayersConfigPresenter presenter = new NumOfPlayersConfigPresenter(view, new ConfigurationModel());
    setScene(view, "/fxml/NumOfPlayersConfig.fxml");
  }

  public void goToMapScreen(Map map) {
        MapViewController view = new MapViewController(stage);
        MapViewPresenter presenter = new MapViewPresenter(view, map);
        setScene(view, "/fxml/MapScreen.fxml");
        presenter.updateTiles();
    }
}
