package ua.shykun.delivery.domain;

import java.util.List;


public class Order {

    private Integer id;
    private Customer customer;
    private List<Pizza> pizzas;
    
    public Order(int id, Customer customer, List<Pizza> pizzas) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public Order(Customer customer, List<Pizza> pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
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
