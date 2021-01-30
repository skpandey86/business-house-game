package info.skpandey.businesshouse;

import info.skpandey.businesshouse.models.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Game")
class GameTest {

    // Game inputs
    public static final int BANK_INITIAL_MONEY = 5000;
    public static final int PLAYER_INITIAL_MONEY = 1000;
    public static final String DICE_OUTPUTS = "2,2,1,4,4,2,4,4,2,2,2,1,4,4,2,4,4,2,2,2,1";
    //public static final String DICE_OUTPUTS = "2,2,1,4,2,3,4,1,3,2,2,7,4,7,2,4,4,2,2,2,2";
    public static final int NO_OF_PLAYERS = 3;

    Game game;
    Bank bank;
    List<Player> players = new ArrayList<>();
    Player player1;
    Player player2;
    Player player3;

    @BeforeEach
    @Test
    @DisplayName("should be initialized")
    void init(){

        // 3 players starting the game with 1000 amount
        player1 = new Player(1, PLAYER_INITIAL_MONEY);
        player2 = new Player(2, PLAYER_INITIAL_MONEY);
        player3 = new Player(3, PLAYER_INITIAL_MONEY);

        players.add(player1);
        players.add(player2);
        players.add(player3);

        // Bank with initial money
        bank = new Bank(BANK_INITIAL_MONEY);
        // Create game object
        game = new Game(GameUtilities.setupGameBoard(), bank, players);
    }

    @Test
    @DisplayName("should throw error when setup with less than 2 players")
    void throwErrorWhenLessThanTwoPlayers(){
        List<Player> players = new ArrayList<>();
        Player player1 = new Player(1, PLAYER_INITIAL_MONEY);
        players.add(player1);
        assertThrows(RuntimeException.class, () -> new Game(GameUtilities.setupGameBoard(), bank, players));
    }

    @Test
    @DisplayName("is played successfully with a single set")
    void verifyResultAfterASingleSet(){
        player1.setDiceOutput(2);
        player2.setDiceOutput(2);
        player3.setDiceOutput(1);
        game.play();

        assertEquals(850, player1.getMoney());
        assertEquals(950, player2.getMoney());
        assertEquals(850, player3.getMoney());

        assertEquals(200, player1.calculateAsset());
        assertEquals(0, player2.calculateAsset());
        assertEquals(0, player3.calculateAsset());

        assertEquals(5350, bank.getMoney());
    }

    @Test
    @DisplayName("is completed successfully")
    void verifyFinalResult(){
        // Parsing dice outputs
        String[] diceOutputArray = DICE_OUTPUTS.split(",");
        int numberOfPlayers = NO_OF_PLAYERS;
        int numberOfTurn = diceOutputArray.length/numberOfPlayers;

        // Play begins
        int pad = 0;
        for (int i=0; i<numberOfTurn; i++){

            int p1DiceIndex = i+pad;
            int p2DiceIndex = i+1+pad;
            int p3DiceIndex = i+2+pad;

            player1.setDiceOutput(Integer.parseInt(diceOutputArray[p1DiceIndex]));
            player2.setDiceOutput(Integer.parseInt(diceOutputArray[p2DiceIndex]));
            player3.setDiceOutput(Integer.parseInt(diceOutputArray[p3DiceIndex]));

            // Play the game for this turn
            game.play();

            pad += numberOfPlayers - 1;
        }

        assertEquals(1400, player1.getMoney());
        assertEquals(0, player2.getMoney());
        assertEquals(150, player3.getMoney());

        assertEquals(1000, player1.calculateAsset());
        assertEquals(0, player2.calculateAsset());
        assertEquals(0, player3.calculateAsset());

        assertEquals(6450, bank.getMoney());

    }

    @Test
    @DisplayName("is completed successfully with output")
    void verifyFinalResultOutput(){

        // Parsing dice outputs
        String[] diceOutputArray = DICE_OUTPUTS.split(",");
        int numberOfPlayers = NO_OF_PLAYERS;
        int numberOfTurn = diceOutputArray.length/numberOfPlayers;

        // Play begins
        int pad = 0;
        for (int i=0; i<numberOfTurn; i++){

            int p1DiceIndex = i+pad;
            int p2DiceIndex = i+1+pad;
            int p3DiceIndex = i+2+pad;

            player1.setDiceOutput(Integer.parseInt(diceOutputArray[p1DiceIndex]));
            player2.setDiceOutput(Integer.parseInt(diceOutputArray[p2DiceIndex]));
            player3.setDiceOutput(Integer.parseInt(diceOutputArray[p3DiceIndex]));

            // Play the game for this turn
            game.play();

            pad += numberOfPlayers - 1;
        }

        String expectedResult = "Player1 has total money 1400 and asset of amount: 1000\n" +
                "Player2 has total money 0 and asset of amount: 0\n" +
                "Player3 has total money 150 and asset of amount: 0\n" +
                "Balance at bank: 6450";
        assertEquals(expectedResult, game.result());
    }

    @Test
    @DisplayName("give bonus upon board completion")
    void giveBonus(){
        Game game = new Game(GameUtilities.setupGameBoard(), bank, GameUtilities.assemblePlayers(3));
        game.play();
        //assertEquals();
    }

}