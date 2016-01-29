package ua.shykun.delivery.domain;

import java.util.List;

public class Customer {

    private Integer id;
    private String name;

    private List<Address> addresses;
    private AccumulativeCard accumulativeCard;

    public Customer() {}

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccumulativeCard getAccumulativeCard() {
        return accumulativeCard;
    }

    public void setAccumulativeCard(AccumulativeCard accumulativeCard) {
        this.accumulativeCard = accumulativeCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
