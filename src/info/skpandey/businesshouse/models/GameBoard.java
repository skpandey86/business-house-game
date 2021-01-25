package info.skpandey.businesshouse.models;

import java.util.List;

/**
 * Represents the Game Board
 */
public class GameBoard {

    private List<Cell> cells;

    public GameBoard(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

}
