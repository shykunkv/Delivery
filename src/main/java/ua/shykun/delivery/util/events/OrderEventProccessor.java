package ua.shykun.delivery.util.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProccessor {

    @EventListener
    public void proccessOrderEvent(OrderEvent orderEvent) {
        System.out.println("Order event: " + orderEvent.getEventType() + " with total price=" + orderEvent.getOrder().getTotalPrice());
    }
}
