package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.domain.orderCost.DiscountManager;
import ua.shykun.delivery.repository.OrderRepository;
import ua.shykun.delivery.service.CustomerService;
import ua.shykun.delivery.service.OrderService;
import ua.shykun.delivery.service.PizzaService;

import java.util.HashMap;
import java.util.Map;


@Service
public class SimpleOrderService implements OrderService {


    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final CustomerService customerService;


    @Autowired
    public SimpleOrderService(
            OrderRepository orderRepository,
            PizzaService pizzaService,
            CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
    }

    @Override
    public Order placeNewOrder(Integer customerID, Integer[] pizzasID, DiscountManager discountManager) {

        Map<Pizza, Integer> pizzas = new HashMap<>();

        for (int pizzaID : pizzasID) {
            Pizza pizza = pizzaService.find(pizzaID);
            if (pizzas.containsKey(pizza)) {
                pizzas.put(pizza, pizzas.get(pizza) + 1);
            } else {
                pizzas.put(pizza, 1);
            }
        }

        Order order = new Order();
        order.setDiscountManager(discountManager);

        order.setPizzas(pizzas);

        Customer customer = customerService.find(customerID);
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
