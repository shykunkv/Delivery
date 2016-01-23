package ua.shykun.delivery.service;

import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.PizzaRepository;
import ua.shykun.delivery.util.ServiceLocator;

public class SimplePizzaService implements PizzaService {

    private final PizzaRepository pizzaRepository;

    public SimplePizzaService() throws InstantiationException, IllegalAccessException {
        pizzaRepository = (PizzaRepository) ServiceLocator.getInstance().createObject("pizzaRepository");
    }
    
    @Override
    public Pizza find(Integer id) {
        return pizzaRepository.find(id);
    }
}
