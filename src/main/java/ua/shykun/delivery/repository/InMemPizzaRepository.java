package ua.shykun.delivery.repository;

import ua.shykun.delivery.domain.Pizza;
import java.util.HashMap;
import java.util.Map;


public class InMemPizzaRepository implements PizzaRepository {

    private static final Map<Integer, Pizza> pizzas = new HashMap<>();

    public void init() {
        pizzas.put(1, new Pizza(1, "name1", 10.0, Pizza.PizzaType.VEGETARIAN));
        pizzas.put(2, new Pizza(2, "name2", 20.0, Pizza.PizzaType.MEAT));
        pizzas.put(3, new Pizza(3, "name3", 30.0, Pizza.PizzaType.SEA));
    }

    @Override
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }
}
