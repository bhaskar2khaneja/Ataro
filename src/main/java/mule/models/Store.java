package mule.models;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Store implements java.io.Serializable {

    @FXML
    private Label availableFunds;

    @FXML
    private Label cost;

    private int foodUnits;
    private int energyUnits;
    private int smithoreUnits;
    private int muleUnits;

    private static Store store = null;

    protected Store() {
        this.foodUnits = 16;
        this.energyUnits = 16;
        this.smithoreUnits = 0;
        this.muleUnits = 25;
    }

    public static Store getInstance() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }

    public static void setStore(Store storeState) {
        store = storeState;
    }

    public int getResourcePrice(int arrowPosition) {
        Resource foodResource = Resource.FOOD;
        Resource energyResource = Resource.ENERGY;
        Resource smithoreResource = Resource.SMITHORE;
        Resource foodMuleResource = Resource.FOODMULE;
        Resource energyMuleResource = Resource.ENERGYMULE;
        Resource smithoreMuleResource = Resource.SMITHOREMULE;
        switch(arrowPosition) {
            case 0:
                return foodResource.getPrice();
            case 1:
                return energyResource.getPrice();
            case 2:
                return smithoreResource.getPrice();
            case 3:
                return foodMuleResource.getPrice();
            case 4:
                return energyMuleResource.getPrice();
            case 5:
                return smithoreMuleResource.getPrice();
        }
        return 0;
    }

    public void initiateBuy(int arrowPosition, Player player) {
        switch(arrowPosition) {
            case 0: 
                player.buyFood(getResourcePrice(arrowPosition));
                break;
            case 1:
                player.buyEnergy(getResourcePrice(arrowPosition));
                break;
            case 2:
                player.buySmithore(getResourcePrice(arrowPosition));
                break;
            case 3:
                player.buyMule(Resource.FOODMULE);
                break;
            case 4:
                player.buyMule(Resource.ENERGYMULE);
                break;
            case 5:
                player.buyMule(Resource.SMITHOREMULE);
                break;
        }
    }

    public void initiateSell(int arrowPosition, Player player) {
        switch(arrowPosition) {
            case 0:
                player.sellFood(getResourcePrice(arrowPosition));
                break;
            case 1:
                player.sellEnergy(getResourcePrice(arrowPosition));
                break;
            case 2:
                player.sellSmithore(getResourcePrice(arrowPosition));
                break;
        }
    }

}