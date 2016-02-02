package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.PizzaRepository;
import ua.shykun.delivery.service.PizzaService;
import ua.shykun.delivery.util.ServiceLocator;

@Service
public class SimplePizzaService implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) throws InstantiationException, IllegalAccessException {
        this.pizzaRepository = pizzaRepository;
    }
    
    @Override
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    }
}
