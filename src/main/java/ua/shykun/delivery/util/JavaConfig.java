package ua.shykun.delivery.util;

import ua.shykun.delivery.repository.InMemOrderRepository;
import ua.shykun.delivery.repository.InMemPizzaRepository;
import ua.shykun.delivery.service.SimpleOrderService;
import ua.shykun.delivery.service.SimplePizzaService;

import java.util.HashMap;
import java.util.Map;


public class JavaConfig implements Config {

    private final Map<String, Class<?>> ifc2Class = new HashMap<>();

    public JavaConfig() {
        ifc2Class.put("pizzaRepository", InMemPizzaRepository.class);
        ifc2Class.put("orderRepository", InMemOrderRepository.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
        ifc2Class.put("orderService", SimpleOrderService.class);
    }

    @Override
    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
