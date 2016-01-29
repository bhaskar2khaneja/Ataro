package mule.presenters;

import mule.views.ColorConfigController;
import mule.models.ConfigurationModel;

public class ColorConfigPresenter extends Presenter<ColorConfigController, ConfigurationModel> {
  public ColorConfigPresenter(ColorConfigController view, ConfigurationModel model) {
    super(view, model);
  }

  @Override
  public void pressUp() {
    view.moveArrowUp();
    model.setColor(view.getArrowPosition());
  }

  @Override
  public void pressDown() {
    view.moveArrowDown();
    model.setColor(view.getArrowPosition());
  }

  @Override
  public void pressA() {
    view.goToRaceConfigController(model);
  }

  @Override
  public void pressB() {
    pressA();
  }
}
