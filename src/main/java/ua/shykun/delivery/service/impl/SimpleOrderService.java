package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.OrderRepository;
import ua.shykun.delivery.service.CustomerService;
import ua.shykun.delivery.service.OrderService;
import ua.shykun.delivery.service.PizzaService;

import java.util.HashMap;
import java.util.Map;


public class SimpleOrderService implements OrderService {


    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final CustomerService customerService;

    //private ApplicationContext applicationContext;

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
    //@Benchmark
    public Order placeNewOrder(Customer customer, Integer[] pizzasID, Integer[] pizzaQuantity) {

        Map<Pizza, Integer> pizzas = new HashMap<>();
        for (int i = 0; i < pizzasID.length; i++) {
            pizzas.put(getPizzaByID(pizzasID[i]), pizzaQuantity[i]);
        }

        Order order = createOrder();
        order.setPizzas(pizzas);

        //Customer customer = customerService.find(customerID);
        order.setCustomer(customer);


        System.out.println(order.getTotalPrice());
        saveOrder(order);
        return order;
    }


    protected Order createOrder() {
        System.out.print("HELLO");
        return null;
    };

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

    private void saveOrder(Order order) {
        orderRepository.save(order);
    }

}
