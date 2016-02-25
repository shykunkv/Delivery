package ua.shykun.delivery.domain.ordercost;


import ua.shykun.delivery.domain.Order;

public interface DiscountManager {
    double calculateTotalOrderPrice(Order order);
}
