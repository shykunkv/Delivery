package ua.shykun.delivery.domain;

import java.util.Date;
import java.util.Map;


public class Order {

    public enum OrderStatus {NEW, IN_PROGRESS, CANCELED, DONE};

    private Integer id;
    private Date date;
    private Customer customer;
    private Map<Pizza, Integer> pizzas;

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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", pizzas=" + pizzas +
                '}';
    }
}
