package ua.shykun.delivery.util.events;

import org.springframework.context.ApplicationEvent;
import ua.shykun.delivery.domain.Order;


public class OrderEvent extends ApplicationEvent {

    private String eventType;
    private Order order;

    public OrderEvent(Object source, String eventType, Order order) {
        super(source);
        this.eventType = eventType;
        this.order = order;
    }

    public String getEventType() {
        return eventType;
    }

    public Order getOrder() {
        return order;
    }
}
