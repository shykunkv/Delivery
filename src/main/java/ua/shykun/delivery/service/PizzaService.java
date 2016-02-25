package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.Pizza;

import java.util.List;


public interface PizzaService {
    Pizza find(Long id);
    Pizza save(Pizza pizza);
    List<Pizza> findAll();
}
