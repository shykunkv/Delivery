package ua.shykun.delivery.domain;

public class AccumulativeCard {

    private Integer id;
    private double balance;

    public AccumulativeCard() {
        this.balance = 0.0;
    }

    public AccumulativeCard(double balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void increaseBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public String toString() {
        return "Card[" + "balance=" + balance + ']';
    }
}
