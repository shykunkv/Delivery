package ua.shykun.delivery;

import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.service.OrderService;
import ua.shykun.delivery.util.ApplicationContext;
import ua.shykun.delivery.util.JavaConfig;
import ua.shykun.delivery.util.JavaConfigApplicationContext;


public class DeliveryApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new JavaConfigApplicationContext(new JavaConfig());

        OrderService orderService = (OrderService) context.getBean("orderService");
        Order order = orderService.placeNewOrder(null, 4, 5);

        System.out.println(order);
    }
}
