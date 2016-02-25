package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.util.annotations.Benchmark;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.OrderItem;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.domain.ordercost.DiscountManager;
import ua.shykun.delivery.repository.OrderRepository;
import ua.shykun.delivery.service.CustomerService;
import ua.shykun.delivery.service.OrderService;
import ua.shykun.delivery.service.PizzaService;
import ua.shykun.delivery.util.events.OrderEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SimpleOrderService implements OrderService, ApplicationEventPublisherAware {


    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final CustomerService customerService;
    private final DiscountManager discountManager;

    private ApplicationEventPublisher publisher;

    @Autowired
    public SimpleOrderService(
            OrderRepository orderRepository,
            PizzaService pizzaService,
            CustomerService customerService,
            DiscountManager discountManager) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.customerService = customerService;
        this.discountManager = discountManager;
    }

    @Benchmark
    @Transactional
    public Order placeNewOrder(Long customerID, Integer[] pizzasID) {

        Map<Pizza, Integer> pizzas = new HashMap<>();

        for (long pizzaID : pizzasID) {
            Pizza pizza = pizzaService.find(pizzaID);
            if (pizzas.containsKey(pizza)) {
                pizzas.put(pizza, pizzas.get(pizza) + 1);
            } else {
                pizzas.put(pizza, 1);
            }
        }

        List<OrderItem> orderItemList = new ArrayList<>();

        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setPizza(entry.getKey());
            orderItem.setPizzaNum(entry.getValue());
            orderItem.setPizzaPrice(entry.getKey().getPrice() * entry.getValue());
            orderItemList.add(orderItem);
        }

        Order order = new Order(discountManager);
        order.setOrderItems(orderItemList);

        Customer customer = customerService.find(customerID);
        order.setCustomer(customer);

        saveOrder(order);

        publisher.publishEvent(new OrderEvent(this, "NEW_ORDER", order));
        return order;
    }

    private Pizza getPizzaByID(Long id) {
        return pizzaService.find(id);
    }

    private void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    public Order placeNewOrder(Integer customerID, Integer[] pizzasID) {
        return null;
    }
}
