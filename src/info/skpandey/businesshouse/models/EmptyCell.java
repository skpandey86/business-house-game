package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.CellType;

public class EmptyCell extends Cell {

    public EmptyCell() {
        super(CellType.E);
    }

    /**
     * The core game logic resides here.
     *
     * Empty cell - no logic defined yet!!
     *
     * @param player,
     * @param bank
     */
    @Override
    public void execute(Player player, Bank bank) {
        System.out.println("Empty cell - no logic defined yet!!");
    }
}