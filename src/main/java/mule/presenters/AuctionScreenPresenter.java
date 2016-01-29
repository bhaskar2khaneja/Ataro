package mule.presenters;

import mule.models.*;
import mule.views.*;
import mule.presenters.*;

public class AuctionScreenPresenter extends Presenter<AuctionScreenController, Void> {
  public AuctionScreenPresenter(AuctionScreenController view) {
    super(view, null);
  }

  @Override
  public void pressA() {
    view.goToMapScreen(Map.getInstance());
    Turn.nextTurn();
  }

  @Override
  public void pressB() {
    pressA();
  }
}
