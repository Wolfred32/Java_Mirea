package ru.mirea.filyev.pract2_task2;

public class Customer {
    private String gameToBuy;
    private float moneyInWallet;

    public Customer(String gameToBuy, float moneyInWallet) {
        this.gameToBuy = gameToBuy;
        this.moneyInWallet = moneyInWallet;
    }

    public String getGameName() {
        return gameToBuy;
    }

    public float getMoney() {
        return moneyInWallet;
    }

}
