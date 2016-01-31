package ua.shykun.delivery.service.impl;

import ua.shykun.delivery.annotations.Benchmark;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.OrderRepository;
import ua.shykun.delivery.service.CustomerService;
import ua.shykun.delivery.service.OrderService;
import ua.shykun.delivery.service.PizzaService;
import ua.shykun.delivery.util.ServiceLocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimpleOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final CustomerService customerService;
    
    public SimpleOrderService(
            OrderRepository orderRepository,
            PizzaService pizzaService,
            CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
    }
    
    @Override
    //@Benchmark
    public Order placeNewOrder(Customer customer, Integer... pizzasID) {


        Map<Pizza, Integer> pizzas = new HashMap<>();
        for (Integer id : pizzasID) {
            pizzas.put(getPizzaByID(id), 1);
        }

        Order order = new Order();
        order.setPizzas(pizzas);

        //Customer customer = customerService.find(customerID);
        order.setCustomer(customer);

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
