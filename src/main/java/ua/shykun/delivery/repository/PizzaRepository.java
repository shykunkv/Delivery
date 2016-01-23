package ua.shykun.delivery.repository;

import ua.shykun.delivery.domain.Pizza;

public interface PizzaRepository {
    Pizza find(Integer id);
}
