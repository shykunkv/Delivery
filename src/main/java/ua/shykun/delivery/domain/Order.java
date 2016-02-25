package ua.shykun.delivery.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ua.shykun.delivery.domain.ordercost.DiscountManager;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    public enum OrderStatus {NEW, IN_PROGRESS, CANCELED, DONE};


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "order_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status;

    @Transient
    private DiscountManager discountManager;

    public Order() {
        date = new Date();
    }

    public Order(DiscountManager discountManager) {
        date = new Date();
        this.discountManager = discountManager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return discountManager.calculateTotalOrderPrice(this);
    }

    public DiscountManager getDiscountManager() {
        return discountManager;
    }

    public void setDiscountManager(DiscountManager discountManager) {
        this.discountManager = discountManager;
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        if (status.ordinal() >= this.status.ordinal() && !this.status.equals(OrderStatus.CANCELED)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid new order status.");
        }
    }

    @Override
    public String toString() {
        return "Order[" + id + ", " +
                status + " ]:" +
                ", customer=" + customer.getName();
    }
}
