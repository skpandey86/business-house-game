package info.skpandey.businesshouse;

import info.skpandey.businesshouse.constants.CellType;
import info.skpandey.businesshouse.constants.HotelCategory;
import info.skpandey.businesshouse.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameUtilities {

    public static List<Cell> cells;

    public static GameBoard setupGameBoard(){
        // Setup game board
        cells = Arrays.asList(
                new Jail(),
                new Hotel("h1", "HotelOne", HotelCategory.SILVER),
                new Lottery(),
                new Hotel("h2", "HotelTwo", HotelCategory.SILVER),
                null,
                new Lottery(),
                new Hotel("h3", "HotelThree", HotelCategory.SILVER),
                new Lottery(),
                new Hotel("h4", "HotelFour", HotelCategory.SILVER),
                new Jail()
        );
        return new GameBoard(cells);
    }


}
