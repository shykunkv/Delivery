package ua.shykun.delivery.repository.impl;

import org.springframework.stereotype.Repository;
import ua.shykun.delivery.domain.AccumulativeCard;
import ua.shykun.delivery.repository.AccumulativeCardRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Repository
public class InMemAccumulativeCardRepository implements AccumulativeCardRepository {

    private static Map<Integer, AccumulativeCard> accumulativeCards = new HashMap<>();

    @PostConstruct
    public void init() {
        accumulativeCards.put(1, new AccumulativeCard(0.0));
        accumulativeCards.put(2, new AccumulativeCard(10.0));
        accumulativeCards.put(3, new AccumulativeCard(20.0));
    }

    @Override
    public AccumulativeCard find(int id) {
        return accumulativeCards.get(id);
    }

    @Override
    public void update(AccumulativeCard accumulativeCard) {
        throw new UnsupportedOperationException();
    }
}
