package mule.models;

import javafx.scene.Parent;

public abstract class Tile extends Parent implements java.io.Serializable {

    protected Player owner;
    protected int cost;
    protected Resource mule;

    public Tile(int cost) {
        this.cost = cost;
    }

    public Player getOwner() {
        return owner;
    }

    protected void setOwner(Player owner) {
        this.owner = owner;
    }

    public Resource getMule() {
        return mule;
    }

    public boolean setMule(Resource mule, Player owner) {
        if (this.owner != owner || this.mule != null) {
            return false;
        }
        this.mule = mule;
        return true;
    }

    public int getCost() {
        return cost;
    }

    public ConfigurationModel.Color getColor() {
        if (owner != null) {
            return owner.getColor();
        } else {
            return null;
        }
    }

    public abstract void produce();

    public abstract int getIntCode();

}