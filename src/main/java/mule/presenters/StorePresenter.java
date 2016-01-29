package mule.presenters;

import mule.views.StoreController;
import mule.models.Turn;
import mule.models.Store;

public class StorePresenter extends Presenter<StoreController, Store> {

    public StorePresenter(StoreController view, Store model) {
        super(view, model);
    }

    @Override
    public void pressUp() {
        view.moveArrowUp();
        updateLabels();
    }   

    @Override
    public void pressDown() {
        view.moveArrowDown();
        updateLabels();
    }

    @Override
    public void pressStart() {
        if (view.getArrowPosition() == 6) {
            view.goToTown();
        } else {
            model.initiateBuy(view.getArrowPosition(), Turn.getCurrentPlayer());
            updateLabels();
        }
    }

    @Override
    public void pressA() {
        pressStart();
    }

    @Override
    public void pressS() {
        if (view.getArrowPosition() == 6) {
            view.goToTown();
        } else {
            model.initiateSell(view.getArrowPosition(), Turn.getCurrentPlayer());
            updateLabels();
        }
    }

    public void updateLabels() {
        view.setFundsLabel((int) Turn.getCurrentPlayer().getMoney());
        view.setCostLabel(model.getResourcePrice(view.getArrowPosition()));
        view.updatePlayerInventory(Turn.getCurrentPlayer().getFood(), Turn.getCurrentPlayer().getEnergy(),
                Turn.getCurrentPlayer().getSmithore(), Turn.getCurrentPlayer().getMuleString());
    }

}