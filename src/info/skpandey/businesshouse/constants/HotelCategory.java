package info.skpandey.businesshouse.constants;

import static info.skpandey.businesshouse.Demo.*;

public enum HotelCategory {

    SILVER(SILVER_HOTEL_VALUE, SILVER_HOTEL_RENT),
    GOLD(GOLD_HOTEL_VALUE, GOLD_HOTEL_RENT),
    PLATINUM(PLATINUM_HOTEL_VALUE, PLATINUM_HOTEL_RENT);

    int value;
    int rent;

    HotelCategory(int value, int rent) {
        this.value = value;
        this.rent = rent;
    }

    public int getValue() {
        return value;
    }

    public int getRent() {
        return rent;
    }
}
