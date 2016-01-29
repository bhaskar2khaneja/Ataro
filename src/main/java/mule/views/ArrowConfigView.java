package mule.views;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public abstract class ArrowConfigView extends View {
  @FXML
  protected GridPane grid;

  @FXML
  protected ImageView arrow;

  public ArrowConfigView(Stage stage) {
    super(stage);
  }

  /**
   * Moves the arrow down. If already at the bottom, the arrow should go to the
   * first row.
   */
  public abstract void moveArrowDown();

  /**
   * Moves the arrow up. If already at the top, the arrow should go to the last
   * row.
   */
  public abstract void moveArrowUp();

  /**
   * Gets the arrow's row index on the grid pane.
   * @return The arrow's row index.
   */
   public int getArrowPosition() {
       return grid.getRowIndex(arrow);
   }
}
