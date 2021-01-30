package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.CellType;

public class Jail extends Cell {

    public Jail() {
        super(CellType.J);
    }

    /**
     * The core game logic resides here.
     *
     * When the user lands on it, a defined amount, for e.g. Rs 150,
     * will be deducted from user's money
     * and sent to bank.
     *
     * @param player,
     * @param bank
     */
    @Override
    void executeCellLogic(Player player, Bank bank) {
        player.deductMoney(CellType.J.getValue());
        bank.deposit(CellType.J.getValue());
    }
}
