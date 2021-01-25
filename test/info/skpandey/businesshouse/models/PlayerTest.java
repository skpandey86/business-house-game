package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.HotelCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Player")
class PlayerTest {

    private Player player;
    @BeforeEach
    @Test
    @DisplayName("should be initialized")
    void init(){
        player = new Player(1, 1000);
    }

    @Test
    @DisplayName("should have initial money")
    void testInitialMoney(){
        assertEquals(1, player.getId()); // is it required in this test
        assertEquals(1000, player.getMoney());
    }

    @Test
    @DisplayName("can set cell position")
    void testCellPosition() {
        player.setDiceOutput(2);
        assertEquals(2, player.getDiceOutput());
    }

    @Test
    @DisplayName("can have assets")
    void testCalculateAsset(){
        Hotel hotel = new Hotel("h1", "HotelOne", HotelCategory.SILVER);
        player.addHotel(hotel);
        assertEquals(200, player.calculateAsset());
    }

    @Test
    @DisplayName("can deduct money")
    void testDeductMoney(){
        player.deductMoney(200);
        assertEquals(800, player.getMoney());
    }

    @Test
    @DisplayName("can add money")
    void testAddMoney(){
        player.addMoney(200);
        assertEquals(1200, player.getMoney());
    }

}