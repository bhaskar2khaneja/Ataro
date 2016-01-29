package mule.models;

public class M1Tile extends Tile {
    public M1Tile() {
        super(500);
    }

    public int getIntCode() {
        return 1;
    }

    @Override
    public void produce() {
        if (mule != null && owner.getEnergy() > 0) {
            int food = 0;
            int energy = 0;
            int ore = 0;
            switch (mule) {
                case FOODMULE:
                    food = 1;
                    break;
                case ENERGYMULE:
                    energy = 1;
                    break;
                case SMITHOREMULE:
                    ore = 2;
                    break;
            }
            energy = energy - 1;
            owner.increaseFood(food);
            owner.increaseEnergy(energy);
            owner.increaseSmithore(ore);
        }
    }

}