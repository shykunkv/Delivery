package ua.shykun.delivery.util;


import org.springframework.beans.factory.FactoryBean;
import ua.shykun.delivery.domain.Pizza;

public class PizzaFactoryBean implements FactoryBean<Pizza> {

    private String name;
    private Double price;
    private Pizza.PizzaType type;

    @Override
    public Pizza getObject() throws Exception {
        return null;
        //return new Pizza(name, price, type);
    }

    @Override
    public Class<?> getObjectType() {
        return Pizza.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Pizza.PizzaType getType() {
        return type;
    }

    public void setType(Pizza.PizzaType type) {
        this.type = type;
    }
}
