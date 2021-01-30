package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.CellType;

/**
 * Represents Cell of Business House Game
 *
 * @author Sandeep Pandey
 *
 */
public abstract class Cell {

    private CellType cellType;

    Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    /**
     * The core game logic resides here.
     * @param player,
     * @param bank,
     * @param boardSize
     */
    public void execute(Player player, Bank bank, int boardSize) {
        // Execute cell specific logic
        executeCellLogic(player, bank);

        // update player's cell position
        player.setCurrentCellPosition();

        // reward player if completed the board game first
        if (player.getCurrentCellPosition() == boardSize) {
            System.out.println("Player" + player.getId() + " has won");
            rewardPlayer(player, bank);
        }
        rewardPlayer(player, bank);
    }

    /**
     * The cell specific logic resides here.
     * @param player,
     * @param bank
     */
    abstract void executeCellLogic(Player player, Bank bank);

    /**
     * Reward the player who completed first
     * @param player
     * @param bank
     */
    public void rewardPlayer(Player player, Bank bank){
        player.addMoney(200);
        bank.withdraw(200);
    }

}
