package ua.shykun.delivery.domain;

public class AccumulativeCard {

    private Integer id;
    private double balance;

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

    @Override
    public String toString() {
        return "AccumulativeCard{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
