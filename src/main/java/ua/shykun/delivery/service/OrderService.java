package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.Customer;
import ua.shykun.delivery.domain.Order;

public interface OrderService {
    Order placeNewOrder(Integer customerID, Integer... pizzasID);
}
