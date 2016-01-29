package mule.views;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mule.models.Store;
import mule.presenters.TownPresenter;

public class StoreController extends ArrowConfigView {

    @FXML
    private Label funds;

    @FXML
    private Label cost;

    @FXML
    private Label foodNum;

    @FXML
    private Label energyNum;

    @FXML
    private Label smithoreNum;

    @FXML
    private Label muleType;

    public StoreController(Stage stage) {
        super(stage);
    }

    @Override
    public void moveArrowUp() {
        grid.setRowIndex(arrow, ((grid.getRowIndex(arrow) - 1) % 7 + 7) % 7);
    }

    @Override
    public void moveArrowDown() {
        grid.setRowIndex(arrow, (grid.getRowIndex(arrow) + 1) % 7);
    }

    public void setFundsLabel(int amount) {
        funds.setText(String.valueOf(amount));
    }

    public void setCostLabel(int amount) {
        cost.setText(String.valueOf(amount));
    }

    public void updatePlayerInventory(int foodNum, int energyNum, int smithoreNum, String muleType) {
        this.foodNum.setText(String.valueOf(foodNum));
        this.energyNum.setText(String.valueOf(energyNum));
        this.smithoreNum.setText(String.valueOf(smithoreNum));
        this.muleType.setText(muleType);
    }

    public void goToTown() {
        TownController view = new TownController(stage);
        TownPresenter presenter = new TownPresenter(view);
        setScene(view, "/fxml/Town.fxml");
    }

}