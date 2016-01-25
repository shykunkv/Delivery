package ua.shykun.delivery;

import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.InMemOrderRepository;
import ua.shykun.delivery.repository.InMemPizzaRepository;
import ua.shykun.delivery.repository.OrderRepository;
import ua.shykun.delivery.repository.PizzaRepository;
import ua.shykun.delivery.service.OrderService;
import ua.shykun.delivery.service.PizzaService;
import ua.shykun.delivery.service.SimpleOrderService;
import ua.shykun.delivery.service.SimplePizzaService;
import ua.shykun.delivery.util.ApplicationContext;
import ua.shykun.delivery.util.JavaConfig;
import ua.shykun.delivery.util.JavaConfigApplicationContext;

public class DeliveryApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());

        OrderService orderService = (OrderService) context.getBean("orderService");
        Order order = orderService.placeNewOrder(new Customer(1, "Gary"), 1, 2);

        System.out.println(order);
    }
}
