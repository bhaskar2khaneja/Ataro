package mule.views;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import mule.models.Map;
import mule.models.Resource;
import mule.models.Round;
import mule.models.Turn;
import mule.presenters.TownPresenter;
import mule.models.ConfigurationModel.Color;
import mule.presenters.AuctionScreenPresenter;


public class MapViewController extends View {

    @FXML
    public GridPane mapGrid;

    @FXML
    private Label moneyLabel;

    @FXML
    private Rectangle tileSelector;

    @FXML
    public static ProgressBar timerBar = new ProgressBar();

    public static void setTimerBar(double secondsRemaining) {
        timerBar.setProgress(secondsRemaining);
    }

    public MapViewController(Stage stage) {
        super(stage);
    }

    // private Label generateLabel(String s) {
    //     Label label = new Label(s);
    //     label.setTextAlignment(TextAlignment.CENTER);
    //     return label;
    // }

    public void fullTimer() {
        timerBar.setProgress(1.00);
    }

    private javafx.scene.paint.Color colorToJavaFXColor(Color color) {
        javafx.scene.paint.Color newColor = null;
        switch(color) {
            case SALMON:
                newColor = javafx.scene.paint.Color.SALMON;
                break;
            case BLUE:
                newColor = javafx.scene.paint.Color.BLUE;
                break;
            case GREEN:
                newColor = javafx.scene.paint.Color.GREEN;
                break;
            case PINK:
                newColor = javafx.scene.paint.Color.PINK;
                break;
        }
        return newColor;
    }

    public void setTiles(int[][] mapDesign) {
        Label label = new Label();
        for (int i = 0; i < mapDesign.length; i++) {
            for (int j = 0; j < mapDesign[0].length; j++) {
                switch (mapDesign[i][j]) {
                    case 0:
                        label = new Label("TOWN");
                        break;
                    case 1:
                        label = new Label("M1");
                        break;
                    case 2:
                        label = new Label("M2");
                        break;
                    case 3:
                        label = new Label("M3");
                        break;
                    case 4:
                        label = new Label("P");
                        break;
                    case 5:
                        label = new Label("R");
                        break;
                }
                Color color = mule.models.Map.getInstance().getTile(j, i).getColor();
                if (color != null) {
                    label.setTextFill(colorToJavaFXColor(color));
                }
                // Specifies if the tile contains a mule
                Resource aMule = mule.models.Map.getInstance().getTile(j, i).getMule();
                if (aMule != null) {
                    label.setText(label.getText() + "\n" + aMule.toString().replaceAll("\\p{Lower}", ""));
                }
                mapGrid.add(label, j, i);
            }
        }
        moneyLabel.setText("Money:\n\n" +
                "\n - " + Turn.getTurn(0).getPlayer().getName() + ": " + Turn.getTurn(0).getPlayer().getMoney() +
                "\n - " + Turn.getTurn(1).getPlayer().getName() + ": " + Turn.getTurn(1).getPlayer().getMoney() +
                "\n - " + Turn.getTurn(2).getPlayer().getName() + ": " + Turn.getTurn(2).getPlayer().getMoney() +
                "\n - " + Turn.getTurn(3).getPlayer().getName() + ": " + Turn.getTurn(3).getPlayer().getMoney() +
                "\n\nRound: " + Round.getInstance().getRoundNum() +
                "\nTurn: "+ Turn.getCurrentTurn().getPlayer().getName());
    }

    public void goToTown() {
        TownController view = new TownController(stage);
        TownPresenter presenter = new TownPresenter(view);
        setScene(view, "/fxml/Town.fxml");
    }

    public void goToAuctionScreen() {
        AuctionScreenController view = new AuctionScreenController(stage);
        AuctionScreenPresenter presenter = new AuctionScreenPresenter(view);
        setScene(view, "/fxml/AuctionScreen.fxml");
    }

    public void showTileSelector() {
        tileSelector.setVisible(true);
    }
    public void hideTileSelector() {
        tileSelector.setVisible(false);
    }
    public void setTileSelectorColor(Color color) {
        tileSelector.setStroke(colorToJavaFXColor(color));
    }

    /**
     * Return the coordinates of the tile selector
     * @return int[] of the form {x location, y location}
     */
    public int[] getTileSelectorLocation() {
        return new int[]{mapGrid.getColumnIndex(tileSelector), mapGrid.getRowIndex(tileSelector)};
    }
    public void tileSelectorUp() {
        mapGrid.setRowIndex(tileSelector, (mapGrid.getRowIndex(tileSelector) + 4) % 5);
    }
    public void tileSelectorDown() {
        mapGrid.setRowIndex(tileSelector, (mapGrid.getRowIndex(tileSelector) + 1) % 5);
    }
    public void tileSelectorLeft() {
        mapGrid.setColumnIndex(tileSelector, (mapGrid.getColumnIndex(tileSelector) + 8) % 9);
    }
    public void tileSelectorRight() {
        mapGrid.setColumnIndex(tileSelector, (mapGrid.getColumnIndex(tileSelector) + 1) % 9);
    }



}
