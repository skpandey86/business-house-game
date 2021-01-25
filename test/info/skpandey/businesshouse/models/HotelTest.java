package info.skpandey.businesshouse.models;

import info.skpandey.businesshouse.constants.HotelCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Hotel")
class HotelTest {

    Hotel hotel;

    @BeforeEach
    @Test
    @DisplayName("should be initialized")
    void init(){
        hotel = new Hotel("h1","HotelOne", HotelCategory.SILVER);
    }

    @Test
    @DisplayName("should be of SILVER type by default")
    void shouldBeOfSilverTypeByDefault(){
        assertEquals(HotelCategory.SILVER, hotel.getHotelCategory());
    }

    @Test
    @DisplayName("should not have any owner by default")
    void shouldNotHaveOwnerByDefault(){
        assertEquals(null, hotel.getHotelOwner());
    }

    @Test
    @DisplayName("should throw error when type is not SILVER by default")
    void shouldThrowErrorWhenNotSilverByDefault(){
        assertThrows(RuntimeException.class,
                () -> new Hotel("h1","HotelOne", HotelCategory.GOLD));
    }

}