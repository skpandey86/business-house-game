package info.skpandey.businesshouse;

import info.skpandey.businesshouse.models.*;

import java.util.List;

/**
 * Represents the Business House Game
 *
 * @author Sandeep Pandey
 *
 */
public class Game {

    private final GameBoard gameBoard;
    private final List<Player> players;
    private final Bank bank;

    public Game(GameBoard gameBoard, Bank bank, List<Player> players) {

        // Game should have at least two players
        if (players.size() < 2)
            throw new RuntimeException("Minimum 2 players are needed!");

        this.gameBoard = gameBoard;
        this.bank = bank;
        this.players = players;
    }

    /**
     * This method gets executed for each turn
     */
    public void play(){

        for (Player player: players){

            // Player moves to the cell position based on the dice output
            int diceOutput = player.getDiceOutput();

            // As list start with index 0; the index would be dice output - 1
            int cellIndex = diceOutput - 1;
            cellIndex += player.getCurrentCellPosition();

            if (cellIndex > gameBoard.getCells().size()) {
                System.out.println("Cant play this time!");
                break;
            }

            // Finding the right cell
            Cell cell = gameBoard.getCells().get(cellIndex);

            // Execute the cell logic
            cell.execute(player, bank, gameBoard.getCells().size());

        }

    }


    public String result(){
        StringBuilder result = new StringBuilder();
        for (Player player: players) {
            result.append(player).append("\n");
        }
        result.append(bank);
        return result.toString();
    }

}