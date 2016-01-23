package ua.shykun.delivery;

import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.service.SimpleOrderService;

public class DeliveryApp {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        SimpleOrderService orderService = new SimpleOrderService();
        Order order = orderService.placeNewOrder(new Customer(1, "Gary"), 1, 2);

        System.out.println(order);
    }
}
