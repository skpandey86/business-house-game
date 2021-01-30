package info.skpandey.businesshouse.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Player of the Business House Game
 *
 * @author Sandeep Pandey
 *
 */

public class Player {

    private final int id;

    private int currentCellPosition;
    private int diceOutput;
    private int money;
    private List<Hotel> hotels = new ArrayList<>();

    // Player with initial money
    public Player(int id, int money) {
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    void setCurrentCellPosition() {
        this.currentCellPosition += diceOutput;
    }

    public int getCurrentCellPosition() {
        return currentCellPosition;
    }


    public void setDiceOutput(int diceOutput){
        this.diceOutput = diceOutput;
    }

    public int getDiceOutput(){
        return diceOutput;
    }

    public int getMoney() {
        return money;
    }

    void deductMoney(int amount){
        this.money -= amount;
    }

    public void addMoney(int amount){
        this.money += amount;
    }

    void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /**
     * Method to get the current asset of a player
     * @return the assets; currently the sum of values of all the hotel player owns
     */
    public int calculateAsset(){
        int totalAsset = 0;
        if (null != hotels) {
            for (Hotel hotel : hotels) {
                totalAsset += hotel.getHotelCategory().getValue();
            }
        }
        return totalAsset;
    }

    @Override
    public String toString() {
        return "Player" + id +
                " Current Cell position " + currentCellPosition +
                " has total money " + money +
                " and asset of amount: " + calculateAsset() + "\n";
    }
}
