package mule.views;

import javafx.stage.Stage;
import mule.models.ConfigurationModel;
import mule.models.Map;
import mule.presenters.MapViewPresenter;
import mule.presenters.NumOfPlayersConfigPresenter;
import mule.presenters.StartScreenPresenter;

public class NameConfigController extends View {
  public NameConfigController(Stage stage) {
    super(stage);
  }

    public void goToMapScreen(Map map) {
        MapViewController view = new MapViewController(stage);
        MapViewPresenter presenter = new MapViewPresenter(view, map);
        setScene(view, "/fxml/MapScreen.fxml");
        presenter.updateTiles();
    }
}
