package mule.models;

import java.io.*;

/**
 * Created by Ricardo De Andrade on 9/24/15.
 */
public class Round implements java.io.Serializable {

    private static int roundNum = 1;
    private final int TOTAL_ROUNDS = 12;
    private static Round round = new Round();

    public static Round getInstance() {
        return round;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public static void writeObject(ObjectOutputStream out) throws Exception {
        out.writeInt(roundNum);
    }

    public static void readObject(ObjectInputStream in) throws Exception {
        roundNum = in.readInt();
    }

    /**
     * @return True if the game continues. False if the game is over;
     */
    public static boolean nextRound() {
        roundNum++;
        if (roundNum <= 12) {
            Map.getInstance().calculateProduction();
            return true;
        } else {
            return false;
        }

    }
    public void reset() {
        roundNum = 1;
    }
}
