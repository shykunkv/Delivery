package ua.shykun.delivery.repository.impl;

import org.springframework.stereotype.Repository;
import ua.shykun.delivery.annotations.AfterCreate;
import ua.shykun.delivery.annotations.Benchmark;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.PizzaRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemPizzaRepository implements PizzaRepository {

    private Map<Integer, Pizza> pizzas = new HashMap<>();

    public InMemPizzaRepository() {

    }

    @PostConstruct
    public void init() {
        pizzas.put(1, new Pizza("VEGETARIAN", 10.0, Pizza.PizzaType.VEGETARIAN));
        pizzas.put(2, new Pizza("MEAT", 20.0, Pizza.PizzaType.MEAT));
        pizzas.put(3, new Pizza("SEA", 30.0, Pizza.PizzaType.SEA));
    }

    @Override
    @Benchmark
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }
}
