package mule.models;

public class RTile extends Tile {

    public RTile() {
        super(500);
    }

    public int getIntCode() {
        return 5;
    }

    @Override
    public void produce() {
        if (mule != null && owner.getEnergy() > 0) {
            int food = 0;
            int energy = 0;
            int ore = 0;
            switch (mule) {
                case FOODMULE:
                    food = 4;
                    break;
                case ENERGYMULE:
                    energy = 2;
                    break;
                case SMITHOREMULE:
                    ore = 0;
                    break;
            }
            energy = energy - 1;
            owner.increaseFood(food);
            owner.increaseEnergy(energy);
            owner.increaseSmithore(ore);
        }
    }

}