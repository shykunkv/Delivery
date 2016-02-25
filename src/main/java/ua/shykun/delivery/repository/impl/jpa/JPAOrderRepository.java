package ua.shykun.delivery.repository.impl.jpa;

import org.springframework.stereotype.Repository;
import ua.shykun.delivery.domain.Order;
import ua.shykun.delivery.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPAOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Order save(Order order) {
        if (order.getId() == null) {
            em.persist(order);
        } else {
            em.merge(order);
        }

        return order;
    }
}
