package info.skpandey.businesshouse.constants;

import static info.skpandey.businesshouse.Demo.JAIL_FINE;
import static info.skpandey.businesshouse.Demo.LOTTERY_VALUE;

public enum CellType {
    J(JAIL_FINE),
    H(0),
    L(LOTTERY_VALUE),
    E(0);

    int value;

    CellType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
