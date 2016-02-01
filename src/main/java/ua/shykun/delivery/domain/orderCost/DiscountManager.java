package ua.shykun.delivery.domain.orderCost;


import ua.shykun.delivery.domain.Order;

public interface DiscountManager {
    double calculateTotalOrderPrice(Order order);
}
