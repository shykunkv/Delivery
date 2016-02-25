package ua.shykun.delivery.domain.ordercost;

import org.springframework.stereotype.Component;
import ua.shykun.delivery.domain.AccumulativeCard;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.domain.OrderItem;

import java.util.List;

@Component
public class SimpleDiscountManager implements DiscountManager {

    private final static int MAX_PIZZA_IN_ORDER = 10;
    private final static double MAX_BONUS_SIZE_FROM_CARD = 0.3;
    private final static double BONUS_SIZE_FROM_CARD = 0.1;
    private final static int MIN_PIZZA_TO_DISCOUNT = 4;
    private final static double DISCOUNT_SIZE = 0.3;

    SimpleDiscountManager() {}

    @Override
    public double calculateTotalOrderPrice(Order order) {
        isValdOrder(order);
        if (order.getCustomer().getAccumulativeCard() == null) {
            return getTotalPrice(order.getOrderItems());
        } else {
            return getTotalPriceWithCard(order.getOrderItems(), order.getCustomer().getAccumulativeCard());
        }
    }

    private void isValdOrder(Order order) {
        if (order == null || order.getOrderItems() == null) {
            throw new NullPointerException("Invalid order");
        }

        int amountOfPizzas = 0;
        List<OrderItem> orderItems = order.getOrderItems();


        for (OrderItem orderItem: orderItems) {
            int quantity = orderItem.getPizzaNum();
            if (quantity <= 0) {
                throw new IllegalArgumentException("Invalid amount of pizza");
            }
            amountOfPizzas += quantity;
        }

        if (amountOfPizzas == 0) {
            throw new IllegalArgumentException("Order without pizzas");
        }

        if (amountOfPizzas > MAX_PIZZA_IN_ORDER) {
            throw new IllegalArgumentException("Order with more that 10 pizzas");
        }
    }

    private double getTotalPrice(List<OrderItem> orderItems) {
        double totalPrice = 0.0;
        double maxPizzaPrice = 0.0;
        int numOfPizzas = 0;

        for (OrderItem orderItem: orderItems) {
//            if (.getPrice() > maxPizzaPrice) {
//                maxPizzaPrice = pizza.getPrice();
//            }
            //numOfPizzas += pizzas.get(pizza);
            totalPrice += orderItem.getPizzaPrice();
        }

//        if (numOfPizzas > MIN_PIZZA_TO_DISCOUNT) {
//            totalPrice -= maxPizzaPrice * DISCOUNT_SIZE;
//        }

        return totalPrice;
    }

    private double getTotalPriceWithCard(List<OrderItem> orderItems, AccumulativeCard accumulativeCard) {
        double priceWithoutCard = getTotalPrice(orderItems);
//        if (Double.compare(accumulativeCard.getBalance(), 0.0) == 0) {
            return priceWithoutCard;
//        } else {
//            double bonusSize = priceWithoutCard * BONUS_SIZE_FROM_CARD;
//            double maxBonusSize = accumulativeCard.getBalance() * MAX_BONUS_SIZE_FROM_CARD;
//
//            if (Double.compare(bonusSize, maxBonusSize) > 0) {
//                accumulativeCard.setBalance(accumulativeCard.getBalance() - maxBonusSize);
//                return priceWithoutCard - maxBonusSize;
//            } else {
//                accumulativeCard.setBalance(accumulativeCard.getBalance() - bonusSize);
//                return priceWithoutCard - bonusSize;
//            }
//        }
    }
}
