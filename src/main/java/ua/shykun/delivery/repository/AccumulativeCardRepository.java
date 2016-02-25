package ua.shykun.delivery.repository;

import ua.shykun.delivery.domain.AccumulativeCard;

public interface AccumulativeCardRepository {
    AccumulativeCard find(Long id);
    AccumulativeCard save(AccumulativeCard accumulativeCard);
}
