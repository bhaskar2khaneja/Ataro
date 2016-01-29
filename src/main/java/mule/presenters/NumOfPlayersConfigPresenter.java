package mule.presenters;

import mule.views.NumOfPlayersConfigController;
import mule.models.ConfigurationModel;

public class NumOfPlayersConfigPresenter extends Presenter<NumOfPlayersConfigController, ConfigurationModel> {
  public NumOfPlayersConfigPresenter(NumOfPlayersConfigController view, ConfigurationModel model) {
    super(view, model);
  }

  @Override
  public void pressUp() {
    view.moveArrowUp();
    model.setNumOfPlayers(view.getArrowPosition() + 1);
  }

  @Override
  public void pressDown() {
    view.moveArrowDown();
    model.setNumOfPlayers(view.getArrowPosition() + 1);
  }

  @Override
  public void pressA() {
    view.goToDifficultyConfig(model);
  }

  @Override
  public void pressB() {
    pressA();
  }
}
