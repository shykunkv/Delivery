package ua.shykun.delivery.repository.impl.inmem;

import ua.shykun.delivery.util.annotations.Benchmark;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.PizzaRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public Pizza find(Long id) {
        return pizzas.get(id);
    }

    @Override
    public Pizza save(Pizza pizza) {
        return pizzas.get(pizza);
    }

    @Override
    public List<Pizza> getAll() {
        return null;
    }
}
