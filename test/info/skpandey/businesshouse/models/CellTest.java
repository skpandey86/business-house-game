package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.CellType;
import info.skpandey.businesshouse.constants.HotelCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game Board Cell")
class CellTest {

    private Cell gameBoardCell;

    @Test
    @BeforeEach
    @DisplayName("should be initialized")
    void init() {
        gameBoardCell = new EmptyCell();
    }

    @Test
    @DisplayName("can be empty")
    void canBeEmpty(){
        assertEquals(CellType.E, gameBoardCell.getCellType());
    }

    @Test
    @DisplayName("can be JAIL")
    void canBeJail(){
        gameBoardCell = new Jail();
        assertEquals(CellType.J, gameBoardCell.getCellType());
    }

    @Test
    @DisplayName("can be LOTTERY")
    void canBeLottery(){
        gameBoardCell = new Lottery();
        assertEquals(CellType.L, gameBoardCell.getCellType());
    }

    @Test
    @DisplayName("can be HOTEL")
    void canBeHotel(){
        gameBoardCell = new Hotel("1","Hotel1", HotelCategory.SILVER);
        assertEquals(CellType.H, gameBoardCell.getCellType());
    }

}