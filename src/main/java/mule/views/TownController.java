package mule.views;

import javafx.stage.Stage;
import mule.models.Map;
import mule.models.Store;
import mule.presenters.MapViewPresenter;
import mule.presenters.InstallMulePresenter;
import mule.presenters.StartScreenPresenter;
import mule.presenters.StorePresenter;

public class TownController extends View {

    public TownController(Stage stage) {
        super(stage);
    }

    public void goToMapScreen(Map model) {
        MapViewController view = new MapViewController(stage);
        MapViewPresenter presenter = new MapViewPresenter(view, model);
        setScene(view, "/fxml/MapScreen.fxml");
        presenter.updateTiles();
    }

    public void goToStore(Store model) {
        StoreController view = new StoreController(stage);
        StorePresenter presenter = new StorePresenter(view, model);
        setScene(view, "/fxml/Store.fxml");
        presenter.updateLabels();
    }

    public void goToInstallMule(Map model) {
        MapViewController view = new MapViewController(stage);
        InstallMulePresenter presenter = new InstallMulePresenter(view, model);
        setScene(view, "/fxml/MapScreen.fxml");
        presenter.updateTiles();
    }
}
