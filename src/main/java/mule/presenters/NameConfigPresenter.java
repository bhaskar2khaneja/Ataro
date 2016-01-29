package mule.presenters;

import mule.models.*;
import mule.views.*;
import mule.presenters.*;


import mule.models.Map;
import mule.views.NameConfigController;


public class NameConfigPresenter extends Presenter<NameConfigController, Void> {
    public NameConfigPresenter(NameConfigController view) {
    super(view, null);
  }

  @Override
  public void pressStart() {
      view.goToMapScreen(Map.getInstance());
      Turn.startPlaying();
  }
}
