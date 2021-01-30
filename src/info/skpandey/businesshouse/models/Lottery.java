package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.CellType;

public class Lottery extends Cell {

    public Lottery() {
        super(CellType.L);
    }

    /**
     * Lottery cell specific logic resides here.
     *
     * When the user lands on it, a defined amount, for e.g. Rs 200,
     * will be added to user's money
     * and deducted from bank.
     *
     * @param player,
     * @param bank
     */
    @Override
    public void executeCellLogic(Player player, Bank bank) {
        player.addMoney(CellType.L.getValue());
        bank.withdraw(CellType.L.getValue());
    }

}
