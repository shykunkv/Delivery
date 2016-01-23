package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.OrderRepository;
import ua.shykun.delivery.util.ServiceLocator;

import java.util.ArrayList;
import java.util.List;


public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    
    public SimpleOrderService() throws InstantiationException, IllegalAccessException {
        orderRepository = (OrderRepository) ServiceLocator.getInstance().createObject("orderRepository");
        pizzaService = (PizzaService) ServiceLocator.getInstance().createObject("pizzaService");
    }
    
    @Override
    public Order placeNewOrder(Customer customer, Integer... pizzasID) {
        List<Pizza> pizzas = new ArrayList<>();

        for (Integer id : pizzasID) {
            pizzas.add(getPizzaByID(id));
        }

        Order order = new Order(customer, pizzas);

        saveOrder(order);
        return order;
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

    private void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
