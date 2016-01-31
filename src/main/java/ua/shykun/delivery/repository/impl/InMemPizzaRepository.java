package ua.shykun.delivery.repository.impl;

import ua.shykun.delivery.annotations.AfterCreate;
import ua.shykun.delivery.annotations.Benchmark;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.PizzaRepository;

import java.util.HashMap;
import java.util.Map;


public class InMemPizzaRepository implements PizzaRepository {

    private Map<Integer, Pizza> pizzas;


    public InMemPizzaRepository(Map<Integer, Pizza> pizzas) {
        this.pizzas = pizzas;
    }

//    @Benchmark
//    public void init() {
//        pizzas.put(1, new Pizza(1, "VEGETARIAN", 10.0, Pizza.PizzaType.VEGETARIAN));
//        pizzas.put(2, new Pizza(2, "MEAT", 20.0, Pizza.PizzaType.MEAT));
//        pizzas.put(3, new Pizza(3, "SEA", 30.0, Pizza.PizzaType.SEA));
//    }
//
//    @AfterCreate
//    public void addCheesePizza() {
//        pizzas.put(4, new Pizza(4, "CHEESE #1", 40.0, Pizza.PizzaType.CHEESE));
//    }
//
//    @AfterCreate
//    public void addAnotherCheesePizza() {
//        pizzas.put(5, new Pizza(5, "CHEESE #2", 50.0, Pizza.PizzaType.CHEESE));
//    }

    @Override
    @Benchmark(measure = Benchmark.Measure.NANOS)
    public Pizza find(Integer id) {
        return pizzas.get(id);
    }
}
