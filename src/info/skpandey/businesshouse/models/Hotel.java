package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.CellType;
import info.skpandey.businesshouse.constants.HotelCategory;
import java.util.Objects;

/**
 * Represent Hotel of the Business House Game
 *
 * @author Sandeep Pandey
 *
 */
public class Hotel extends Cell {

    private final String hotelId;
    private final String hotelName;
    private HotelCategory hotelCategory;
    private Player hotelOwner;


    public Hotel(String hotelId, String hotelName, HotelCategory hotelCategory) {
        super(CellType.H);

        // Hotel should be SILVER type when created
        if (!hotelCategory.equals(HotelCategory.SILVER))
            throw new RuntimeException("Initial type of hotel can only be SILVER");

        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelCategory = hotelCategory;
    }

    HotelCategory getHotelCategory() {
        return hotelCategory;
    }

    Player getHotelOwner(){
        return hotelOwner;
    }

    private void upgrade(Bank bank){
        if (!hotelCategory.equals(HotelCategory.PLATINUM)) {
            HotelCategory upgradeTo = findUpgradeType();
            int diffAmount = upgradeTo.getValue() - hotelCategory.getValue();

            if (hotelOwner.getMoney() >= diffAmount ) {
                hotelOwner.deductMoney(diffAmount);
                bank.deposit(diffAmount);
                hotelCategory = upgradeTo;
            }
        } else {
            System.out.println("PLATINUM can't be upgraded!");
        }
    }

    private HotelCategory findUpgradeType() {
        switch (hotelCategory) {
            case SILVER:
                return HotelCategory.GOLD;
            case GOLD:
                return HotelCategory.PLATINUM;
            default:
                return HotelCategory.SILVER;
        }
    }

    /**
     * The core game logic resides here.
     *
     * When the player lands on it and has required money,
     * he/she has to buy it by paying the bank
     * the required money to buy a silver hotel.
     *
     * If the player lands on it’s pre-owned hotel and has required money,
     * the user needs to upgrade hotel by paying required delta value.
     *
     * If any other user lands on a pre-owned hotel,
     * the user needs to pay rent as per hotel     *
     *
     * @param player,
     * @param bank
     */
    @Override
    public void execute(Player player, Bank bank) {
        if (null != hotelOwner) {
            if (hotelOwner.getId() == player.getId()) {
                // I own this hotel - pls upgrade
                this.upgrade(bank);
            } else {
                // this is someone else's hotel; pay the rent;
                if (player.getMoney() >= hotelCategory.getRent()) {
                    hotelOwner.addMoney(hotelCategory.getRent());
                    player.deductMoney(hotelCategory.getRent());
                } else {
                    System.out.println("Don't have enough money for rent");
                }
            }
        } else {
            this.buyHotel(player, bank);
        }
    }

    private void buyHotel(Player player, Bank bank){
        int hotelValue = hotelCategory.getValue();
        if (player.getMoney() >= hotelValue) {
            player.deductMoney(hotelValue);
            bank.deposit(hotelValue);
            player.addHotel(this);
            this.hotelOwner = player;
        }
    }

}