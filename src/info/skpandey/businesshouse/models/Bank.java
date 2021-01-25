package info.skpandey.businesshouse.models;

/**
 * Represent the Central Bank in the Business House Game
 *
 * @author Sandeep Pandey
 */
public class Bank {
    private int money;

    public Bank(int money) {
        this.money = money;
    }

    public void deposit(int amount){
        money += amount;
    }

    public void withdraw(int amount){
        money -= amount;
    }

    public int getMoney(){
        return money;
    }
}
