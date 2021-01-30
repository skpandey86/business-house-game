package info.skpandey.businesshouse;

import info.skpandey.businesshouse.models.*;


import java.util.ArrayList;
import java.util.List;

public class Demo {

    // Game inputs
    public static final int BANK_INITIAL_MONEY = 5000;
    public static final int PLAYER_INITIAL_MONEY = 1000;
    public static final int JAIL_FINE = 150;
    public static final int LOTTERY_VALUE = 200;
    public static final int SILVER_HOTEL_VALUE = 200;
    public static final int SILVER_HOTEL_RENT = 50;
    public static final int GOLD_HOTEL_VALUE = 300;
    public static final int GOLD_HOTEL_RENT = 150;
    public static final int PLATINUM_HOTEL_VALUE = 500;
    public static final int PLATINUM_HOTEL_RENT = 300;
    public static final String DICE_OUTPUTS = "2,2,1,4,4,2,4,4,2,2,2,1,4,4,2,4,4,2,2,2,1";
    //public static final String DICE_OUTPUTS = "2,2,1,4,2,3,4,1,3,2,2,7,4,7,2,4,4,2,2,2,2";
    public static final int NO_OF_PLAYERS = 3;

    public static void main(String[] args) {

        // 3 players starting the game with 1000 amount
        List<Player> players = GameUtilities.assemblePlayers(NO_OF_PLAYERS);

        // Bank with initial money
        Bank bank = new Bank(BANK_INITIAL_MONEY);
        // Create game object
        Game game = new Game(GameUtilities.setupGameBoard(), bank, players);

        // Parsing dice outputs
        String diceOutputArray[] = DICE_OUTPUTS.split(",");
        //int numberOfPlayers = NO_OF_PLAYERS;
        int numberOfPlayers = players.size();
        int numberOfTurn = diceOutputArray.length/numberOfPlayers;

        // Play begins
        int pad = 0;
        for (int i=0; i<numberOfTurn; i++){

            int p1DiceIndex = i+pad;
            for (Player player: players) {
                player.setDiceOutput(Integer.parseInt(diceOutputArray[p1DiceIndex]));
                p1DiceIndex++;
            }

            // Play the game for this turn
            game.play();

            pad += numberOfPlayers - 1;
            System.out.println(players);
        }

        System.out.println("Its time for result : ");
        System.out.println(game.result());

    }



}
