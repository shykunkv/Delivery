package ua.shykun.delivery.domain;

import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name = "accumulative_cards")
public class AccumulativeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accumulative_card_id")
    private Long id;

    @Column(name = "accumulative_card_balance")
    private double balance;

    public AccumulativeCard() {
        this.balance = 0.0;
    }

    public AccumulativeCard(double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
