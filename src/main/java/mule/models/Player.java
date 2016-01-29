package mule.models;

import java.util.Random;

public class Player implements java.io.Serializable {

    private ConfigurationModel.Color color;
    private String name;
    private ConfigurationModel.Race race;
    private double money;
    private int food;
    private int energy;
    private int smithore;
    private Resource mule;

    /**
     * Player constructor
     * @param color
     * @param name
     * @param race Every player starts with 1000
     */
    public Player (ConfigurationModel.Color color, String name, ConfigurationModel.Race race) {
        this.color = color;
        this.name = name;
        this.race = race;
        this.money = getStartingMoney(race);
        this.food = 8;
        this.energy = 4;
        this.smithore = 0;
    }

    //different money amount not reflecting on fxml; how are they getting displayed?
    private double getStartingMoney(ConfigurationModel.Race race) {
        if (race == ConfigurationModel.Race.FLAPPER) return 1600;
        if (race == ConfigurationModel.Race.HUMANOID) return 600;
        return 1000;
    }

    public ConfigurationModel.Color getColor() {
        return color;
    }

    public void setColor(ConfigurationModel.Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConfigurationModel.Race getRace() {
        return race;
    }

    public void setRace(ConfigurationModel.Race race) {
        this.race = race;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getFood() {
        return food;
    }

    public int getEnergy() {
        return energy;
    }

    public int getSmithore() {
        return smithore;
    }

    public Resource getMule() {
        return mule;
    }

    public String getMuleString() {
        if (mule == null) {
            return "None";
        } else {
            return mule.toString();
        }
    }

    public boolean installMule(Tile tile) {
        if (this.mule == null) {
            return false;
        }
        Resource mule = this.mule;
        this.mule = null;
        return tile.setMule(mule, this);
    }

    public boolean buyFood(int foodPrice) {
        if (money - foodPrice < 0) return false;
        money = money - foodPrice;
        food++;
        return true;
    }

    public boolean buyEnergy(int energyPrice) {
        if (money - energyPrice < 0) return false;
        money = money - energyPrice;
        energy++;
        return true;
    }

    public boolean buySmithore(int smithorePrice) {
        if (money - smithorePrice < 0) return false;
        money = money - smithorePrice;
        smithore++;
        return true;
    }

    public boolean buyMule(Resource mule) {
        int mulePrice = mule.getPrice();
        if (money - mulePrice < 0) return false;
        money = money - mulePrice;
        this.mule = mule;
        return true;
    }

    public boolean buyTile(Tile tile) {
        if ((money - tile.getCost()) < 0) {
            return false;
        }
        if (!grantTile(tile)) {
            return false;
        }
        money = money - tile.getCost();
        return true;
    }

    public boolean grantTile(Tile tile) {
        if (tile.getOwner() != null || tile.getIntCode() == 0) {
            return false;
        }
        tile.setOwner(this);
        return true;
    }

    public boolean sellFood(int foodPrice) {
        if (food <= 0) {
            return false;
        }
        money = money + foodPrice;
        food--;
        return true;
    }

    public boolean sellEnergy(int energyPrice) {
        if (energy <= 0) {
            return false;
        }
        money = money + energyPrice;
        energy--;
        return true;
    }

    public boolean sellSmithore(int smithorePrice) {
        if (smithore <= 0) {
            return false;
        }
        money = money + smithorePrice;
        smithore--;
        return true;
    }

    public void increaseFood (int value) {
        food = food + value;
    }

    public void increaseEnergy (int value) {
        energy = energy + value;
    }

    public void increaseSmithore (int value) {
        smithore = smithore + value;
    }

    public void randWin() {
        Random rand = new Random();
        int number = 0;
        number =  rand.nextInt(3);
        System.out.println("Positive Random Event: prepare to win something");
        if (number == 0) {
            System.out.println("Food before: " + this.getFood());
            this.increaseFood(1);
            this.increaseEnergy(1);
            System.out.println("Food after: " + this.getFood());

        } else if (number == 1) {
            System.out.println("Smithore before: " + this.getSmithore());
            this.increaseSmithore(2);
            System.out.println("Smithore after: " + this.getSmithore());
        } else {
            System.out.println("Money before: " + this.getMoney());
            if (this.getMule() != null) {
                this.setMoney(this.getMoney() + 100.0);
            }
            System.out.println("Money after: " + this.getMoney());
        }
    }

    public void randLose() {
        Random rand = new Random();
        int randNum = 0;
        randNum = rand.nextInt(3);
        System.out.println("Negative Random Event: prepare to lose something");
        if (randNum == 0) {
            System.out.println("Money before: " + this.getMoney());
            double value = (this.getMoney() - 100.0);
            if (value < 0) {
                this.setMoney(0);
            } else {
                this.setMoney(value);
            }
            System.out.println("Money After: " + this.getMoney());
        } else if (randNum == 1) {
            System.out.println("Food before: " + this.getFood());
            this.increaseFood(-1);
            System.out.println("Food after: " + this.getFood());
        } else {
            System.out.println("Energy before: " + this.getEnergy());
            this.increaseEnergy(-1);
            System.out.println("Energy After: " + this.getEnergy());
        }

    }

    public void destiny() {
        Random rand = new Random();
        int randNum = 0;
        randNum = rand.nextInt(2);
        if (randNum == 0) {
            this.randWin();
        } else {
            this.randLose();
        }
    }
}
