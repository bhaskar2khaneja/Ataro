package mule.views;

import javafx.stage.Stage;
import mule.models.Map;
import mule.presenters.MapViewPresenter;

public class AuctionScreenController extends View {
  public AuctionScreenController(Stage stage) {
    super(stage);
  }

  /**
   * Goes to the Map screen, the configuration screen to select the number of
   * players.
   */
  public void goToMapScreen(Map model) {
      MapViewController view = new MapViewController(stage);
      MapViewPresenter presenter = new MapViewPresenter(view, model);
      setScene(view, "/fxml/MapScreen.fxml");
  }
}
