package ua.shykun.delivery.repository.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.AccumulativeCard;
import ua.shykun.delivery.repository.AccumulativeCardRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class JPAAccumulativeCardRepository implements AccumulativeCardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public AccumulativeCard find(Long id) {
        return em.find(AccumulativeCard.class, id);
    }

    @Override
    public AccumulativeCard save(AccumulativeCard accumulativeCard) {
        if (accumulativeCard.getId() == null) {
            em.persist(accumulativeCard);
        } else {
            em.merge(accumulativeCard);
        }

        return accumulativeCard;
    }
}
