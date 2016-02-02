package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.AccumulativeCard;

public interface AccumulativeCardService {
    AccumulativeCard find(Integer id);
    void increaseCardSum(AccumulativeCard accumulativeCard, double bonusSum);

}
