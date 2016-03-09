package ua.shykun.delivery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.service.PizzaService;


public class PizzaConverter implements Converter<String, Pizza> {

    @Autowired
    private PizzaService pizzaService;

    @Override
    public Pizza convert(String pizzaId) {
        Pizza pizza;
        if (pizzaId == null || pizzaId.isEmpty()) {
            pizza = new Pizza();
        } else {
            pizza = pizzaService.find(Long.valueOf(pizzaId));
        }
        return pizza;
    }
}
