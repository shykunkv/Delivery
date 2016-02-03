package ua.shykun.delivery.domain;

import org.springframework.beans.factory.annotation.Autowired;
import ua.shykun.delivery.annotations.MyComponent;
import ua.shykun.delivery.domain.orderCost.DiscountManager;

import java.util.Date;
import java.util.Map;


@MyComponent
public class Order {

    public enum OrderStatus {NEW, IN_PROGRESS, CANCELED, DONE};

    private Integer id;
    private Date date;
    private Customer customer;
    private Map<Pizza, Integer> pizzas;
    private OrderStatus status;

    @Autowired
    private DiscountManager discountManager;

    public Order() {
        date = new Date();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Map<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
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

    public Integer getId() {
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
                ", customer=" + customer.getName() +
                ", pizzas=" + pizzas;
    }
}
