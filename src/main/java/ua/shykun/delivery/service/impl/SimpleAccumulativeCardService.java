package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shykun.delivery.domain.AccumulativeCard;
import ua.shykun.delivery.repository.AccumulativeCardRepository;
import ua.shykun.delivery.service.AccumulativeCardService;

@Service
public class SimpleAccumulativeCardService implements AccumulativeCardService {

    private final AccumulativeCardRepository accumulativeCardRepository;

    @Autowired
    public SimpleAccumulativeCardService(AccumulativeCardRepository accumulativeCardRepository) {
        this.accumulativeCardRepository = accumulativeCardRepository;
    }

    @Override
    public AccumulativeCard find(Integer id) {
        return accumulativeCardRepository.find(id);
    }

    @Override
    public void increaseCardSum(AccumulativeCard accumulativeCard, double bonusSum) {
        accumulativeCard.increaseBalance(bonusSum);
        accumulativeCardRepository.update(accumulativeCard);
    }
}
