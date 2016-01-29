package ua.shykun.delivery.repository.impl;

import ua.shykun.delivery.domain.AccumulativeCard;
import ua.shykun.delivery.repository.AccumulativeCardRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemAccumulativeCardRepository implements AccumulativeCardRepository {

    private static Map<Integer, AccumulativeCard> accumulativeCards = new HashMap<>();


    public void init() {
        accumulativeCards.put(1, new AccumulativeCard(0.0));
        accumulativeCards.put(2, new AccumulativeCard(10.0));
        accumulativeCards.put(3, new AccumulativeCard(20.0));
    }

    @Override
    public AccumulativeCard find(int id) {
        return accumulativeCards.get(id);
    }
}
