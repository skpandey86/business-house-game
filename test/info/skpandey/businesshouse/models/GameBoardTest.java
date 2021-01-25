package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.GameUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game Board")
class GameBoardTest {

    GameBoard gameBoard;
    List<Cell> cells = new ArrayList<>();

    @BeforeEach
    @Test
    @DisplayName("should be initialized")
    void init(){
        // Setup game board
        gameBoard = GameUtilities.setupGameBoard();
    }

    @Test
    @DisplayName("should have fixed set of cell")
    void shoudHaveFixedCells(){
        assertEquals(GameUtilities.cells, gameBoard.getCells());
    }
}
