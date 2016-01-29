package mule.models;

public class PTile extends Tile {
    public PTile() {
        super(500);
    }

    public int getIntCode() {
        return 4;
    }

    @Override
    public void produce() {
        if (mule != null && owner.getEnergy() > 0) {
            int food = 0;
            int energy = 0;
            int ore = 0;
            switch (mule) {
                case FOODMULE:
                    food = 2;
                    break;
                case ENERGYMULE:
                    energy = 3;
                    break;
                case SMITHOREMULE:
                    ore = 1;
                    break;
            }
            energy = energy - 1;
            owner.increaseFood(food);
            owner.increaseEnergy(energy);
            owner.increaseSmithore(ore);
        }
    }

}