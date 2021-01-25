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

    protected Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    /**
     * The core game logic resides here.
     * @param player,
     * @param bank
     */
    public abstract void execute(Player player, Bank bank);

}
