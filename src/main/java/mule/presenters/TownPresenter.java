package mule.presenters;

import mule.models.*;
import mule.views.*;
import mule.presenters.*;
import mule.models.Map;
import mule.models.Round;
import mule.views.TownController;
import java.util.Random;
import java.io.*;

public class TownPresenter extends Presenter<TownController, Void> {

    public TownPresenter(TownController view) {
        super(view, null);
    }

    /**
    *
    */
    @Override
    public void pressS() {
        view.goToStore(Store.getInstance());
    }

    @Override
    public void pressW() {
        view.goToInstallMule(Map.getInstance());
    }

    @Override
    public void pressE() {

    }

    /**
    * Press R to get into the pub and gamble
    */
    @Override
    public void pressR() {

        System.out.println(Turn.getCurrentTurn().getPlayer().getName() + " enters Pub");
        Random rand = new Random();
        double gambleMoney = Math.round((rand.nextDouble() * 300.0) + 50.0);
        System.out.println(Turn.getCurrentTurn().getPlayer().getName() + " gambled and won $" + gambleMoney);
        Turn.getCurrentTurn().getPlayer().setMoney(Turn.getCurrentTurn().getPlayer().getMoney() + gambleMoney);
        System.out.println(Turn.getCurrentTurn().getPlayer().getName() + " current money: $" + Turn.getCurrentTurn().getPlayer().getMoney() + "\n");
        if (Turn.nextTurn() == 0) {
            Round.nextRound();
            Turn.sortTurnOrder();
        }
        view.goToMapScreen(Map.getInstance());
        System.out.println(Turn.getCurrentTurn().getPlayer().getName() + " it's your turn\n");
    }

    @Override
    public void pressSelect() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Gamestate.ser"));
            out.writeObject(Map.getInstance());
            Turn.writeObject(out);
            Round.writeObject(out);
            out.writeObject(Store.getInstance());
            out.close();
            System.out.println("Game-State Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
