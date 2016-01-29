package mule.models;
import mule.models.ConfigurationModel.Color;
import mule.models.ConfigurationModel.Race;
import mule.views.MapViewController;

import java.util.Timer;
import java.util.TimerTask;
import java.io.*;


/**
 * Created by Ricardo De Andrade on 9/24/15.
 * Modified by Rohan Avalani on 1/10/15
 * Modified by Fuad Hasbun on 10/1/15
 */
public class Turn implements java.io.Serializable {
    
    private Player player;
    private static int currentTurnNum = 0;

    private static Turn[] turns = new Turn[] {new Turn(new Player(Color.BLUE, "Player1", Race.BONZOID)),
            new Turn(new Player(Color.GREEN, "Player2", Race.BONZOID)),
            new Turn(new Player(Color.PINK, "Player3", Race.BONZOID)),
            new Turn(new Player(Color.SALMON, "Player4", Race.BONZOID))};

    private static Timer timer = new Timer();


    private void stopTimer() {
      this.timer.cancel();
    }

    private static final long TURN_TIME = 1000000;

    private long timeLeft = 0;

    public static void writeObject(ObjectOutputStream out) throws Exception {
        out.writeInt(currentTurnNum);
        out.writeObject(turns[currentTurnNum].getPlayer());
        out.writeObject(turns); 
    }

    public static void readObject(ObjectInputStream in) throws Exception {
        currentTurnNum = in.readInt();
        turns[currentTurnNum].setPlayer((Player) in.readObject());
        turns = (Turn[]) in.readObject();
    }

    /*
    * Still have to figure out how to decrease the ProgressBar
     */
    private void startTimer() {
        this.timer = new Timer();
        this.timeLeft = TURN_TIME;
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (timeLeft > 0) {
                    /*IMPLEMENT STUFF HERE */
                    System.out.println("ping! Player" + " time left:" + timeLeft/1000 + "s\n");
                    MapViewController.setTimerBar((timeLeft/1000)/10.0);
                    /************************/
                } else {
                  nextTurn();
                }
                timeLeft = timeLeft - 1000;
            }
        }, 0, 1000);
    }

    private Turn(Player player) {
        this.player = player;
    }

    public static Turn getCurrentTurn() {
        return turns[currentTurnNum];
    }

    public static Player getCurrentPlayer() {
        return getCurrentTurn().getPlayer();
    }

    /**
    * Selection sort for player order
    */
    public static void sortTurnOrder() {
        int i, j =0;
        int n = turns.length;
        for (i = 0; i < n  ; i++) {
          int minPos = i;
              for (j = i + 1; j < n; j++) {
                if (turns[j].getPlayer().getMoney() < turns[minPos].getPlayer().getMoney()) /* ascending order use < */
                {
                  minPos = j;
                }
              }
              Turn swap  = turns[minPos];
              turns[minPos]   = turns[i];
              turns[i] = swap;
            }
        System.out.println("\nCurrent Turn Order:");
        for ( i = 0; i < turns.length; i++) {
            System.out.println(turns[i].getPlayer().getName());
        }
    }

    public static int getCurrentTurnNum() {
        return currentTurnNum;
    }

    public static Turn getTurn(int turnNum) {
        if (turnNum >= 0 && turnNum <= 3) {
            return turns[turnNum];
        } else {
            return null;
        }
    }

    /**
     * Goes to the next turn
     * @return next turn
     */
    public static int nextTurn() {
        turns[currentTurnNum].stopTimer();
        currentTurnNum = (currentTurnNum + 1) % 4;
        turns[currentTurnNum].startTimer();
        return currentTurnNum;
    }

    public static Turn startPlaying() {
        turns[currentTurnNum].startTimer();
        return turns[currentTurnNum];
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
