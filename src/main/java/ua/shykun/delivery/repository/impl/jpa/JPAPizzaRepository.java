package ua.shykun.delivery.repository.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.PizzaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JPAPizzaRepository implements PizzaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Pizza find(Long id) {
        return em.find(Pizza.class, id);
    }

    @Override
    public Pizza save(Pizza pizza) {

        if (pizza.getId() == null) {
            em.persist(pizza);
        } else {
            em.merge(pizza);
        }

        return pizza;
    }


    @Override
    public List<Pizza> getAll() {
        return em.createQuery("from Pizza").getResultList();
    }

    @Override
    public void delete(Pizza pizza) {
        em.remove(em.contains(pizza) ? pizza : em.merge(pizza));
    }
}
