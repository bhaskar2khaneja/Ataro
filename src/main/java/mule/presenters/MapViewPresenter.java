package mule.presenters;

import mule.models.*;
import mule.views.MapViewController;

public class MapViewPresenter extends Presenter<MapViewController, Map> {

    public MapViewPresenter(MapViewController view, Map model) {
        super(view, model);
    }

    public void updateTiles() {
        view.setTiles(renderMap(model.getCurrentMap()));
    }

    // TODO add color of tile
    public int[][] renderMap(Tile[][] tiles) {
        int[][] mapDesign = new int[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                mapDesign[i][j] = tiles[i][j].getIntCode();
            }
        }
        return mapDesign;
    }

    // Updates the map
    public void updateMap() {
        view.setTiles(renderMap(model.getCurrentMap()));
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

    /**
     * Press A to buy land (free in the first 2 rounds)
     */
    @Override
    public void pressA() {
        int[] location = view.getTileSelectorLocation();
        Tile tile = model.getTile(location[0], location[1]);
        if (Round.getInstance().getRoundNum() <= 2) {
            boolean wasGranted = Turn.getCurrentTurn().getPlayer().grantTile(tile);
            if (wasGranted) {
                view.goToTown();
            }
        } else {
            if (Turn.getCurrentTurnNum() == 0) {
                Turn.getCurrentTurn().getPlayer().randWin();
            } else {
                Turn.getCurrentTurn().getPlayer().destiny();
            }
            if (Turn.getCurrentTurn().getPlayer().buyTile(tile)) {
                view.goToTown();
            } else {
                System.out.println("You don't have enough money");
                view.goToTown();
            }
        }
    }
    @Override
    public void pressB() {
        view.goToTown();

    }

    @Override
    public void pressStart() {
        view.fullTimer();
    }

}
