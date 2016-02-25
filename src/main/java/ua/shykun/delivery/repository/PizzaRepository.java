package ua.shykun.delivery.repository;

import ua.shykun.delivery.domain.Pizza;

import java.util.List;

public interface PizzaRepository {
    Pizza find(Long id);
    Pizza save(Pizza pizza);
    List<Pizza> getAll();
}
