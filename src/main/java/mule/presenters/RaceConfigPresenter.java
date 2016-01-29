package mule.presenters;

import mule.views.RaceConfigController;
import mule.models.ConfigurationModel;

public class RaceConfigPresenter extends Presenter<RaceConfigController, ConfigurationModel> {
  public RaceConfigPresenter(RaceConfigController view, ConfigurationModel model) {
    super(view, model);
  }

  @Override
  public void pressUp() {
    view.moveArrowUp();
    model.setDifficulty(view.getArrowPosition());
  }

  @Override
  public void pressDown() {
    view.moveArrowDown();
    model.setDifficulty(view.getArrowPosition());
  }

  @Override
  public void pressA() {
    view.goToNameConfigScreen();
  }

  @Override
  public void pressB() {
    pressA();
  }
}
