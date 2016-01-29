package mule.presenters;

import mule.views.DifficultyConfigController;
import mule.models.ConfigurationModel;

public class DifficultyConfigPresenter extends Presenter<DifficultyConfigController, ConfigurationModel> {
  public DifficultyConfigPresenter(DifficultyConfigController view, ConfigurationModel model) {
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
    view.goToColorConfigController(model);
  }

  @Override
  public void pressB() {
    pressA();
  }
}
