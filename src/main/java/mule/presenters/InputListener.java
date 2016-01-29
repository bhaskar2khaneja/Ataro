package mule.presenters;

import javafx.scene.input.KeyEvent;

public abstract class InputListener {
  /**
   * Called when the `UP` button is pressed.
   */
  public void pressUp() {
  }

  /**
   * Called when the `DOWN` button is pressed.
   */
  public void pressDown() {
  }

  /**
   * Called when the `LEFT` button is pressed.
   */
  public void pressLeft() {
  }

  /**
     * Called when the `RIGHT` button is pressed.
   */
  public void pressRight() {
  }

  /**
   * Called when the `START` button is pressed.
   */
  public void pressStart() {
  }

  /**
   * Called when the `SELECT` button is pressed.
   */
  public void pressSelect() {
  }

  /**
   * Called when the `A` button is pressed.
   */
  public void pressA() {
  }

  /**
   * Called when the `B` button is pressed.
   */
  public void pressB() {
  }

  public void pressS() {
  }

  public void pressW() {
  }

  public void pressE() {
  }

  public void pressR() {
  }

  /**
  * The event that is fired when this listener gets triggered.
  *
  * @param event The keyboard event that was fired.
  */
  public void onKeyPressed(KeyEvent event) {
    switch (event.getCode()) {
      case UP:
        pressUp();
        break;
      case DOWN:
        pressDown();
        break;
      case LEFT:
        pressLeft();
        break;
      case RIGHT:
        pressRight();
        break;
      case ENTER:
        pressStart();
        break;
      case SPACE:
        pressSelect();
        break;
      case X:
        pressA();
        break;
      case C:
        pressB();
        break;
      case S:
        pressS();
        break;
      case W:
        pressW();
        break;
      case E:
        pressE();
        break;
      case R:
        pressR();
        break;
      default:
        break;
    }
  }
}
