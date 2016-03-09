package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.Pizza;
import ua.shykun.delivery.repository.PizzaRepository;
import ua.shykun.delivery.service.PizzaService;
import ua.shykun.delivery.util.ServiceLocator;

import java.util.List;

@Service
public class SimplePizzaService implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public SimplePizzaService(PizzaRepository pizzaRepository) throws InstantiationException, IllegalAccessException {
        this.pizzaRepository = pizzaRepository;
    }
    
    @Override
    public Pizza find(Long id) {
        return pizzaRepository.find(id);
    }

    @Override
    @Transactional
    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.getAll();
    }

    @Override
    @Transactional
    public void delete(Pizza pizza) {
        pizzaRepository.delete(pizza);
    }
}
