package ua.shykun.delivery.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @ManyToMany
    @JoinColumn(referencedColumnName = "address_id")
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE})
    @Column(name = "customer_addresses")
    private List<Address> addresses;


    @OneToOne
    @JoinColumn(name = "accumulative_card", referencedColumnName = "accumulative_card_id")
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE})
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return name + "[" + id + "]";
    }
}
