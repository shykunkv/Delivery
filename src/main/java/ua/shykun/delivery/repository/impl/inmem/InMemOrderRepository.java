package ua.shykun.delivery.repository.impl.inmem;

import org.springframework.stereotype.Repository;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.repository.OrderRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemOrderRepository implements OrderRepository {

    private static final Map<Integer,Order> orders = new HashMap<>();

    @Override
    public Order save(Order order) {
        orders.put(null, order);
        return order;
    }
}
