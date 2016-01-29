package mule.models;

import java.util.Random;

public class Map implements java.io.Serializable {

    // private final Tile[][] standardMap = new Tile[][] {
    //         {new PTile(), new PTile(), new M1Tile(), new PTile(), new RTile(), new PTile(), new M3Tile(), new PTile(), new PTile()},
    //         {new PTile(), new M1Tile(), new PTile(), new PTile(), new RTile(), new PTile(), new PTile(), new PTile(), new M3Tile()},
    //         {new M3Tile(), new PTile(), new PTile(), new PTile(), new TTile(), new PTile(), new PTile(), new PTile(), new M1Tile()},
    //         {new PTile(), new M2Tile(), new PTile(), new PTile(), new RTile(), new PTile(), new M2Tile(), new PTile(), new PTile()},
    //         {new PTile(), new PTile(), new M2Tile(), new PTile(), new RTile(), new PTile(), new PTile(), new PTile(), new M2Tile()}
    // };

    private static Map map = null;
    private Tile[][] currentMap;

    protected Map() {
        // currentMap = standardMap;
        generateRandomMap();
    }

    private Tile randomTile() {
        Tile[] tiles = {new PTile(), new M1Tile(), new M2Tile(), new M3Tile(), new RTile()};
        Random random = new Random();
        return tiles[random.nextInt(4)];
    }

    private void generateRandomMap() {
        currentMap = new Tile[5][9];
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[0].length; j++) {
                currentMap[i][j] = randomTile();
            }
        }
        currentMap[2][4] = new TTile();
    }

    public static Map getInstance() {
        if (map == null) {
            map = new Map();
        }
        return map;
    }

    public static void setMap(Map mapState) {
        map = mapState;
    }

    public Tile getTile(int x, int y) {
        return currentMap[y][x];
    }

    public Tile[][] getCurrentMap() {
        return currentMap;
    }

    public void calculateProduction() {
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[i].length; j++) {
                currentMap[i][j].produce();
            }
        }
    }

}