package ua.shykun.delivery.repository;

import ua.shykun.delivery.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
