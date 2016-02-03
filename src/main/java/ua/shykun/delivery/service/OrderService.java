package ua.shykun.delivery.service;

import org.springframework.stereotype.Service;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.orderCost.DiscountManager;

public interface OrderService {
    Order placeNewOrder(Integer customerID, Integer[] pizzasID, DiscountManager discountManager);
}
