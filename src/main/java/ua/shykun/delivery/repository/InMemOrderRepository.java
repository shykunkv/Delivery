package ua.shykun.delivery.repository;

import ua.shykun.delivery.domain.Order;
import java.util.ArrayList;
import java.util.List;

public class InMemOrderRepository implements OrderRepository {

    private static final List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }
}
