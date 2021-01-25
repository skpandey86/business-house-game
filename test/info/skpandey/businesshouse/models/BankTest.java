package info.skpandey.businesshouse.models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank should")
class BankTest {

    private Bank bank;

    @Test
    @BeforeEach
    @DisplayName("be able to initialize with initial money")
    void init() {
        bank = new Bank(1000);
    }

    @Test
    @DisplayName("have initial money")
    void testInitialMoney(){
        assertEquals(1000, bank.getMoney());
    }

    @Test
    @DisplayName("be able to deposit money")
    void testDepositMoney(){
        bank.deposit(150);
        assertEquals(1150, bank.getMoney());
    }

    @Test
    @DisplayName("be able to withdraw money")
    void testWithdrawMoney(){
        bank.withdraw(200);
        assertEquals(800, bank.getMoney());
    }

}