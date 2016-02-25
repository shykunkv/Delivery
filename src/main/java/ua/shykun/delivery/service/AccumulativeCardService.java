package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.AccumulativeCard;

public interface AccumulativeCardService {
    AccumulativeCard find(Long id);
    AccumulativeCard save(AccumulativeCard accumulativeCard);
}
