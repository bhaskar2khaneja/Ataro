package mule.presenters;

import mule.models.*;
import mule.views.MapViewController;

/**
 * Created by ricardodeandrade on 10/16/15.
 */
public class InstallMulePresenter extends Presenter<MapViewController, Map> {

    public InstallMulePresenter(MapViewController view, Map model) {
        super(view, model);
    }

    public void updateTiles() {
        view.setTiles(renderMap(model.getCurrentMap()));
    }

    public int[][] renderMap(Tile[][] tiles) {
        int[][] mapDesign = new int[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                mapDesign[i][j] = tiles[i][j].getIntCode();
            }
        }
        return mapDesign;
    }

    @Override
    public void pressUp() {
        view.tileSelectorUp();
    }
    @Override
    public void pressDown() {
        view.tileSelectorDown();
    }
    @Override
    public void pressLeft() {
        view.tileSelectorLeft();
    }
    @Override
    public void pressRight() {
        view.tileSelectorRight();
    }

    @Override
    public void pressA() {
        int[] location = view.getTileSelectorLocation();
        Tile tile = model.getTile(location[0], location[1]);
        Turn.getCurrentTurn().getPlayer().installMule(tile);
        view.goToTown();
    }
}
