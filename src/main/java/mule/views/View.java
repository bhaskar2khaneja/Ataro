package mule.views;

import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import mule.presenters.InputListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public abstract class View {
  protected ArrayList<InputListener> listeners = new ArrayList<>();

  protected Stage stage;

  public View(Stage stage) {
    this.stage = stage;
  }

  @FXML
  private void onKeyPressed(KeyEvent event) {
    for (InputListener listener : listeners) {
      listener.onKeyPressed(event);
    }
  }

  /**
   * Adds an input listener to this view.
   */
  public void addListener(InputListener listener) {
    listeners.add(listener);
  }

  /**
   * Set the scene for the main stage.
   *
   * @param scene The scene to set.
   */
  public void setScene(View view, String resourcePath) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(StartScreenController.class.getResource(resourcePath));
    loader.setController(view);

    try {
      Parent root = loader.load();
      stage.setScene(new Scene(root));
      root.requestFocus();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
