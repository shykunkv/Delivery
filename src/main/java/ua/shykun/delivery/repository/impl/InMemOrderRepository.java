package ua.shykun.delivery.repository.impl;

import ua.shykun.delivery.annotations.Benchmark;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.repository.OrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemOrderRepository implements OrderRepository {

    private static final Map<Integer,Order> orders = new HashMap<>();

    @Override
    public Order save(Order order) {
        orders.put(null, order);
        return order;
    }
}
