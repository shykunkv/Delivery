package ua.shykun.delivery.util;

import ua.shykun.delivery.repository.impl.inmem.InMemCustomerRepository;
import ua.shykun.delivery.repository.impl.inmem.InMemOrderRepository;
import ua.shykun.delivery.repository.impl.inmem.InMemPizzaRepository;
import ua.shykun.delivery.service.impl.SimpleCustomerService;
import ua.shykun.delivery.service.impl.SimpleOrderService;
import ua.shykun.delivery.service.impl.SimplePizzaService;

import java.util.HashMap;
import java.util.Map;


public class JavaConfig implements Config {

    private final Map<String, Class<?>> ifc2Class = new HashMap<>();

    public JavaConfig() {
        ifc2Class.put("pizzaRepository", InMemPizzaRepository.class);
        ifc2Class.put("orderRepository", InMemOrderRepository.class);
        ifc2Class.put("pizzaService", SimplePizzaService.class);
        ifc2Class.put("orderService", SimpleOrderService.class);
        ifc2Class.put("customerService", SimpleCustomerService.class);
        ifc2Class.put("customerRepository", InMemCustomerRepository.class);
    }

    @Override
    public <T> Class<T> getImpl(String ifc) {
        return (Class<T>) ifc2Class.get(ifc);
    }
}
