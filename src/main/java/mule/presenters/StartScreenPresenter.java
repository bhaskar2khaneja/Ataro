package mule.presenters;

import mule.models.*;
import mule.views.StartScreenController;
import java.io.*;

public class StartScreenPresenter extends Presenter<StartScreenController, Void> {
  public StartScreenPresenter(StartScreenController view) {
    super(view, null);
  }

  @Override
  public void pressA() {
    view.goToNumOfPlayersConfig();
  }

  @Override
  public void pressB() {
    pressA();
  }

  @Override
  public void pressW() {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("gamestate.ser"));
      Map.setMap((Map) in.readObject());
      Turn.readObject(in);
      Round.readObject(in);
      Store.setStore((Store) in.readObject());
      in.close();
      System.out.println("Game Loaded");
      view.goToMapScreen(Map.getInstance());
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
