package info.skpandey.businesshouse;

import info.skpandey.businesshouse.constants.HotelCategory;
import info.skpandey.businesshouse.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static info.skpandey.businesshouse.Demo.PLAYER_INITIAL_MONEY;

public class GameUtilities {

    public static List<Cell> cells;

    public static GameBoard setupGameBoard(){
        // Setup game board
        cells = Arrays.asList(
                new Jail(),
                new Hotel("h1", "HotelOne", HotelCategory.SILVER),
                new Lottery(),
                new Hotel("h2", "HotelTwo", HotelCategory.SILVER),
                new EmptyCell(),
                new Lottery(),
                new Hotel("h3", "HotelThree", HotelCategory.SILVER),
                new Lottery(),
                new Hotel("h4", "HotelFour", HotelCategory.SILVER),
                new Jail()
                //new Lottery(),
                //new Hotel("h5", "HotelFive", HotelCategory.SILVER)
        );
        return new GameBoard(cells);
    }

    public static List<Player> assemblePlayers(int noOfPlayers){

        List<Player> players = new ArrayList<>();

        for(int i = 1; i<=noOfPlayers; i++){
            Player player = new Player(i, PLAYER_INITIAL_MONEY);
            players.add(player);
        }

        return players;
    }


}
